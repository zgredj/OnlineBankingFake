package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatenbankCode {

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
}