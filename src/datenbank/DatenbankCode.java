package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gui.MainFrame;

public class DatenbankCode {

	public static String getPasswortVonDatenbank(int kartennummer) {
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT passwort FROM databaseonlinebanking.konto WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("passwort");
			}
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
		return null;
	}

	public static void setRechnungVonDatenbank(int kartennummerEmpfaenger, int kartennummer, double betrag,
			MainFrame mainFrame) throws Exception {

		try {
			int kontoIdEmpfaenger = -1;
			int kontoIdEmpfaengerUnchecked = getKontoIdByKartennummerOrNull(kartennummerEmpfaenger);
			if (kontoIdEmpfaengerUnchecked > 0) {
				kontoIdEmpfaenger = kontoIdEmpfaengerUnchecked;
			} else {
				throw new Exception("Die eingegebene Kartennummer ist nicht vorhanden!");
			}

			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "INSERT INTO databaseonlinebanking.rechnung (versender, betrag, konto_id) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ps.setDouble(2, betrag);
			ps.setInt(3, kontoIdEmpfaenger);

			ps.executeUpdate();

		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public static int getKontoIdByKartennummerOrNull(int kartennummer) {
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT id FROM databaseonlinebanking.konto WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
		return -1;
	}

	public static boolean istKartennummerVorhanden(int kartennummer) {
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT kartennummer FROM databaseonlinebanking.konto WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public static void setKontostandByKartennummer(int kartennummer, double betrag, String einOderAusZahlen,
			MainFrame mainFrame) throws Exception {
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT kontostand FROM databaseonlinebanking.konto WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ResultSet rs = ps.executeQuery();
			double kontostand = 0;
			while (rs.next()) {
				kontostand = rs.getDouble("kontostand");
			}

			if (einOderAusZahlen.equals("einzahlen")) {
				kontostand += betrag;
			} else if (einOderAusZahlen.equals("auszahlen")) {
				if ((kontostand - betrag) >= 0) {
					kontostand -= betrag;
				} else {
					throw new Exception(
							"Der Betrag konnte nicht ausgezahlt werden, da Sie zu wenig Geld auf Ihrem Konto haben!");
				}
			} else {
				System.err.println("Es muss angegeben werden, ob ein- oder ausgezahlt werden soll! " + einOderAusZahlen
						+ " --> einzahlen / auszahlen");
			}

			sql = "UPDATE databaseonlinebanking.konto SET kontostand = ? WHERE kartennummer = ?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, kontostand);
			ps.setInt(2, kartennummer);
			ps.executeUpdate();

		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public static double getKontostandVonDatenbank(int kartennummer) {
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT kontostand FROM databaseonlinebanking.konto WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getDouble("kontostand");
			}
		} catch (SQLException sqlexc) {
			throw new RuntimeException();
		}
		return -1;
	}

	public static ArrayList<Rechnung> getRechnungVonDatenbank(int konto_id) {
		ArrayList<Rechnung> arrayRechnungen = new ArrayList<Rechnung>();
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT id, versender, betrag, konto_id FROM databaseonlinebanking.rechnung WHERE konto_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, konto_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Rechnung rechnung = new Rechnung();
				rechnung.setId(rs.getInt("id"));
				rechnung.setKartennummer(rs.getInt("versender"));
				rechnung.setBetrag(rs.getDouble("betrag"));
				rechnung.setKonto_id(rs.getInt("konto_id"));
				arrayRechnungen.add(rechnung);
			}
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
		return arrayRechnungen;
	}

	public static Konto getVorUndNachnameVonDatenbankByKartennummer(int kartennummerVersender) {
		Konto konto = new Konto();
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT vorname, name FROM databaseonlinebanking.konto WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummerVersender);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				konto.setVorname(rs.getString("vorname"));
				konto.setName(rs.getString("name"));
			}
		} catch (SQLException sqlexc) {
			throw new RuntimeException();
		}
		return konto;
	}

	public static int getAnzahlOfKontoIdVonRechnung(int myKonto_id) {
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "SELECT COUNT(konto_id) AS anzahlKontoId FROM databaseonlinebanking.rechnung WHERE konto_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, myKonto_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt("anzahlKontoId");
			}
		} catch (SQLException sqlexc) {
			throw new RuntimeException();
		}
		return -1;
	}

	public static void deleteRechnungById(int id) {
		try {
			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "DELETE FROM databaseonlinebanking.rechnung WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException sqlexc) {
			throw new RuntimeException();
		}

	}
}
