package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fehlermeldung.Fehlermeldung;
import gui.MainFrame;

public class DatenbankCode {

	Fehlermeldung fehlermeldung = new Fehlermeldung();

	public String getPasswortVonDatenbank(int kartennummer) {
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

	public void setRechnungVonDatenbank(int kartennummerEmpfaenger, int kartennummer, int betrag, MainFrame mainFrame) throws Exception {

		if (kartennummerEmpfaenger == kartennummer) {
			throw new Exception("Sie können sich nicht selbst eine Rechnung stellen!");
		}

		try {
			int kontoIdEmpfaenger = -1;
			int kontoIdEmpfaengerUnchecked = getKontoIdByKartennummerOrNegativeError(kartennummer);
			if (kontoIdEmpfaengerUnchecked > 0) {
				kontoIdEmpfaenger = kontoIdEmpfaengerUnchecked;
			} else {
				throw new Exception("Die eingegebene Kartennummer ist nicht vorhanden!");
			}

			Connection con = ConnectionFactory.getInstance().getConnection();
			String sql = "INSERT INTO databaseonlinebanking.rechnung (versender, betrag, konto_id) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, kartennummer);
			ps.setInt(2, betrag);
			ps.setInt(3, kontoIdEmpfaenger);

			ps.executeUpdate();

		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public boolean istKartennummerVorhanden(int kartennummer) {
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

	private int getKontoIdByKartennummerOrNegativeError(int kartennummer) {
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
}