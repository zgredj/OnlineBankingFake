package datenbank;

public interface KontoDao {
	
	public void insertKonto(Konto k);
	
	public Konto findKontoById(int id);
}