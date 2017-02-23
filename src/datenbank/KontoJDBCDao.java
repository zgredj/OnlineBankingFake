package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KontoJDBCDao {

	private Connection con = null;

	public KontoJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertKontoIntoDatabase(Konto k) {
		try {
			String sql = "INSERT INTO databaseonlinebanking.konto (name, vorname, geburtsdatum, kartennummer, passwort, kontostand) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, k.getName());
			ps.setString(2, k.getVorname());
			ps.setString(3, k.getGeburtsdatum());
			ps.setInt(4, k.getKartennummer());
			ps.setString(5, k.getPasswort());
			ps.setDouble(6, k.getKontostand());

			ps.executeUpdate();

		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public Konto findKontoById(int id) {

		try {
			Konto k = null;
			String sql = "SELECT id, name, vorname, geburtsdatum, kartennummer, passwort, kontostand FROM databaseonlinebanking.konto WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				k = getKontoFromResultSet(rs);
				break;
			}
			return k;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public ArrayList<Konto> getAllKonten() {
		try {
			ArrayList<Konto> konten = new ArrayList<Konto>();

			String sql = "SELECT id, name, vorname, geburtsdatum, kartennummer, passwort, kontostand FROM databaseonlinebanking.konto";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Konto k = getKontoFromResultSet(rs);
				konten.add(k);
			}
			return konten;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public Konto getKontoFromResultSet(ResultSet rs) throws SQLException {
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
}
