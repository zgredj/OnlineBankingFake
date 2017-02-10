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

	public void insertAdresse(Adresse a) {
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
	
	public Adresse findAdresseById(int id) {
		try {
			String sql = "SELECT id, strasse, hausnummer, wohnort, plz from databaseonlinebanking.adresse where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return getAdresseFromResultSet(rs);
			}

			throw new RuntimeException("Adress id not found on database! Id: " + id);
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public ArrayList<Adresse> getAllAdressen() {
		try {
			ArrayList<Adresse> adressen = new ArrayList<Adresse>();
			String sql = "SELECT id, strasse, hausnummer, wohnort, plz FROM databaseonlinebanking.adresse";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Adresse a = getAdresseFromResultSet(rs);
				adressen.add(a);
			}
			return adressen;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	private Adresse getAdresseFromResultSet(ResultSet rs) throws SQLException {
		Adresse a = new Adresse();
		a.setId(rs.getInt("id"));
		a.setStrasse(rs.getString("strasse"));
		a.setHausnummer(rs.getInt("hausnummer"));
		a.setWohnort(rs.getString("wohnort"));
		a.setPlz(rs.getInt("plz"));
		return a;
	}
}