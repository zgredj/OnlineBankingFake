package Datenbank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class AdresseJDBCDao {

	private Connection con = null;

	public void AdresseJBCDao(Connection connection) {
		con = connection;
	}

	public void insertAdresse(Adresse a) {
		try {
			String sql = "INSERT INTO databaseonlinebanking.adresse (strasse, hausnummer, wohnort, plz, email) VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getStrasse());
			ps.setString(2, a.getWohnort());
			ps.setInt(3, a.getPlz());
			ps.setString(4, a.getEmail());

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
				a.setHausnummer(rs.getString("hausnummer"));
				a.setPlz(rs.getInt("plz"));
				a.setEmail(rs.getString("email"));
				break;
			}
			return a;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public ArrayList<Adresse> getAlleAdressen() {
		try {
			ArrayList<Adresse> adressen = new ArrayList<Adresse>();

			String sql = "SELECT id, strasse, hausnummer, wohnort, plz, email FROM databaseonlinebanking.adresse";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Adresse a = new Adresse();
				Konto k = new Konto();
				a.setId(rs.getInt("id"));
				a.setStrasse(rs.getString("strasse"));
				a.setHausnummer(rs.getString("hausnummer"));
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