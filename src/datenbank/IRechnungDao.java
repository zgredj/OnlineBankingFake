package datenbank;

import java.sql.ResultSet;

public interface IRechnungDao {
	
	public void insertRechnung(Rechnung r);
	public Rechnung getRechnungFromResultSet(ResultSet rs);
	
}
