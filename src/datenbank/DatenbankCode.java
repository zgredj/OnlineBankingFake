package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gui.Navigator;

public class DatenbankCode {

	static Connection con = ConnectionFactory.getInstance().getConnection();

	public static String getPasswortVonDatenbank(int kartennummer) {
		try {
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

	public static void setRechnungVonDatenbank(int kartennummerEmpfaenger, int kartennummer, double betrag)
			throws Exception {

		try {
			int kontoIdEmpfaenger = -1;
			int kontoIdEmpfaengerUnchecked = getKontoIdByKartennummerOrNull(kartennummerEmpfaenger);
			if (kontoIdEmpfaengerUnchecked > 0) {
				kontoIdEmpfaenger = kontoIdEmpfaengerUnchecked;
			} else {
				throw new Exception();
			}

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

		throw new RuntimeException("kartennumber not found in db: " + kartennummer);
	}

	public static boolean istKartennummerVorhanden(int kartennummer) {
		try {
			String sql = "SELECT kartennummer FROM databaseonlinebanking.konto WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public static void setKontostandByKartennummer(int kartennummer, double betrag, String einOderAusZahlen) throws Exception {
		try {
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
					throw new Exception();
				}
			} else {
				System.err.println("Es muss angegeben werden, ob ein- oder ausgezahlt werden soll! " + einOderAusZahlen + " --> einzahlen / auszahlen");
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
			String sql = "DELETE FROM databaseonlinebanking.rechnung WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException sqlexc) {
			throw new RuntimeException();
		}
	}

	public static void ueberweiseBezahlteRechnungByKartennummer(int kartennummer, double betrag) {
		try {
			double kontostand = DatenbankCode.getKontostandVonDatenbank(kartennummer);
			kontostand += betrag;
			String sql = "UPDATE databaseonlinebanking.konto SET kontostand = ? WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, kontostand);
			ps.setInt(2, kartennummer);
			ps.executeUpdate();
		} catch (SQLException sqlexc) {
			throw new RuntimeException();

		}
	}

	private static Konto getKontoFromResultSet(ResultSet rs) throws SQLException {
		Konto k = new Konto();
		k.setId(rs.getInt("id"));
		k.setName(rs.getString("name"));
		k.setVorname(rs.getString("vorname"));
		k.setGeburtsdatum(rs.getString("geburtsdatum"));
		k.setKartennummer(rs.getInt("kartennummer"));
		k.setPasswort(rs.getString("passwort"));
		k.setKontostand(rs.getDouble("kontostand"));
		return k;
	}

	public static void setAllUserInformationsByKartennummer(int kartennummer, Navigator nav) {
		try {
			String sql = "SELECT id, name, vorname, geburtsdatum, kartennummer, passwort, kontostand FROM databaseonlinebanking.konto WHERE kartennummer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ResultSet rs = ps.executeQuery();
			Konto konto = new Konto();
			while (rs.next()) {
				konto = getKontoFromResultSet(rs);
			}
			User user = new User();
			user.setId(konto.getId());
			user.setNachname(konto.getName());
			user.setVorname(konto.getVorname());
			user.setGeburtsdatum(konto.getGeburtsdatum());
			user.setKartennummer(konto.getKartennummer());
			user.setPasswort(konto.getPasswort());
			user.setKontostand(konto.getKontostand());
			nav.setUser(user);
		} catch (SQLException sqlexc) {
			throw new RuntimeException();
		}
	}
}
