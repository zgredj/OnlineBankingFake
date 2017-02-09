package datenbank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class AdresseJDBCDao {

	private Connection con = null;

	public AdresseJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertAdresse(Adresse a) {
		try {
			String sql = "INSERT INTO databaseonlinebanking.adresse (strasse, hausnummer, wohnort, plz, email) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getStrasse());
			ps.setInt(2, a.getHausnummer());
			ps.setString(3, a.getWohnort());
			ps.setInt(4, a.getPlz());
			ps.setString(5, a.getEmail());
 
			ps.executeUpdate();

		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public Adresse findAdresseById(int id) {
		try {
			Adresse a = null;
			String sql = "SELECT id, strasse, hausnummer, wohnort, plz, email from databaseonlinebanking.adresse where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Adresse();
				a.setId(rs.getInt("id"));
				a.setStrasse(rs.getString("strasse"));
				a.setHausnummer(rs.getInt("hausnummer"));
				a.setWohnort(rs.getString("wohnort"));
				a.setPlz(rs.getInt("plz"));
				a.setEmail(rs.getString("email"));
				break;
			}
			return a;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public ArrayList<Adresse> getAllAdressen() {
		try {
			ArrayList<Adresse> adressen = new ArrayList<Adresse>();

			String sql = "SELECT id, strasse, hausnummer, wohnort, plz, email FROM databaseonlinebanking.adresse";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Adresse a = new Adresse();
				a.setId(rs.getInt("id"));
				a.setStrasse(rs.getString("strasse"));
				a.setHausnummer(rs.getInt("hausnummer"));
				a.setWohnort(rs.getString("wohnort"));
				a.setPlz(rs.getInt("plz"));
				a.setEmail(rs.getString("email"));
				adressen.add(a);
			}
			return adressen;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}
}