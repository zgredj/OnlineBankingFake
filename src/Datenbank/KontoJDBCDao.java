package Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KontoJDBCDao implements KontoDao {

	private Connection con = null;

	public KontoJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertKonto(Konto k) {
		try {
			String sql = "INSERT INTO projekt.konto (name, vorname, geburtsdatum, kartennummer, passwort, kontostand) VALUES (?,?,?,?,?,?)";
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
			String sql = "SELECT id, name, vorname, geburtsdatum, kartennummer, passwort, kontostand FROM projekt.konto WHERE id = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				k = new Konto();
				k.setId(rs.getInt("id"));
				k.setName(rs.getString("name"));
				k.setVorname(rs.getString("vorname"));
				k.setGeburtsdatum(rs.getString("geburtsdatum"));
				k.setKartennummer(rs.getInt("kartennummer"));
				k.setPasswort(rs.getString("passwort"));
				k.setKontostand(rs.getDouble("kontostand"));
				break;
			}
			return k;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public ArrayList<Konto> getAllKontos() {
		try {
			ArrayList<Konto> kontos = new ArrayList<Konto>();

			String sql = "SELECT id, name, vorname, geburtsdatum, kartennummer, passwort, kontostand FROM projekt.konto";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Konto k = new Konto();
				k.setId(rs.getInt("id"));
				k.setName(rs.getString("name"));
				k.setVorname(rs.getString("vorname"));
				k.setGeburtsdatum(rs.getString("geburtsdatum"));
				k.setKartennummer(rs.getInt("kartennummer"));
				k.setPasswort(rs.getString("passwort"));
				k.setKontostand(rs.getDouble("kontostand"));
				kontos.add(k);
			}
			return kontos;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

}
