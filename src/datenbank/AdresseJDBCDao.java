package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdresseJDBCDao {

	private Connection con = null;

	public AdresseJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertAdresseIntoDatabase(Adresse a) {
		try {
			String sql = "INSERT INTO databaseonlinebanking.adresse (strasse, hausnummer, wohnort, plz) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getStrasse());
			ps.setInt(2, a.getHausnummer());
			ps.setString(3, a.getWohnort());
			ps.setInt(4, a.getPlz());

			ps.executeUpdate();

		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}
}