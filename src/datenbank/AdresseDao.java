package datenbank;

public interface AdresseDao {
	
	public void insertKonto(Adresse a);
	
	public Adresse findKontoById(int id);
}
