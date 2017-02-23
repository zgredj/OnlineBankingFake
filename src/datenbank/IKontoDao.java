package datenbank;

import java.sql.ResultSet;

public interface IKontoDao {
	
	public void insertKontoIntoDatabase(Konto k);
	public Konto getKontoFromResultSet(ResultSet rs);
}
