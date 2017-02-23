package datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RechnungJDBCDao implements IRechnungDao {

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

	public Rechnung getRechnungFromResultSet(ResultSet rs) {
		try {
			Rechnung r = new Rechnung();
			r.setId(rs.getInt("id"));
			r.setKartennummer(rs.getInt("kartennummer"));
			r.setBetrag(rs.getDouble("betrag"));
			return r;
		} catch (SQLException sqlexc) {
			throw new RuntimeException();
		}
	}
}
