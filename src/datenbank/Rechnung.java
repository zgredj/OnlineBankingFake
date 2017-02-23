package datenbank;

public class Rechnung {

	private int id;
	private int kartennummer;
	private double betrag;
	private int konto_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKartennummer() {
		return kartennummer;
	}

	public void setKartennummer(int kartennummer) {
		this.kartennummer = kartennummer;
	}

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public int getKonto_id() {
		return konto_id;
	}

	public void setKonto_id(int konto_id) {
		this.konto_id = konto_id;
	}
}
