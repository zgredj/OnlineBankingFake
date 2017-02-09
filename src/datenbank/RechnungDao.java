package datenbank;

public interface RechnungDao {

	public void insertRechnung(Rechnung r);
	
	public Rechnung findRechnungById(int id);
}
