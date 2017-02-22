package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RechnungJDBCDao {

	private Connection con = null;

	public RechnungJDBCDao(Connection connection) {
		con = connection;
	}

	public void insertRechnung(Rechnung r) {
		try {
			String sql = "INSERT INTO databaseonlinebanking.rechnung (kartennummer, betrag) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, r.getKartennummer());
			ps.setDouble(2, r.getBetrag());
			ps.executeUpdate();
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public Rechnung findRechnungById(int id) {
		try {
			Rechnung r = null;
			String sql = "SELECT id, kartennummer, betrag FROM databaseonlinebanking.rechnung WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = getRechnungFromResultSet(rs);
				break;
			}
			return r;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	public ArrayList<Rechnung> getAllRechnungen() {
		try {
			ArrayList<Rechnung> rechnungen = new ArrayList<Rechnung>();

			String sql = "SELECT id, kartennummer, betrag FROM databaseonlinebanking.rechnung";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Rechnung r = getRechnungFromResultSet(rs);
				rechnungen.add(r);
			}
			return rechnungen;
		} catch (SQLException sqlexc) {
			throw new RuntimeException(sqlexc);
		}
	}

	private Rechnung getRechnungFromResultSet(ResultSet rs) throws SQLException {
		Rechnung r = new Rechnung();
		r.setId(rs.getInt("id"));
		r.setKartennummer(rs.getInt("kartennummer"));
		r.setBetrag(rs.getDouble("betrag"));
		return r;
	}
}
