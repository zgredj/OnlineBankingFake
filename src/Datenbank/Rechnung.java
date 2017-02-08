package Datenbank;

public class Rechnung {

	int id;
	int kartennummer;
	double betrag;

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

	public String toString(){
		String result = "";
		result += this.getId() + " ";
		result += this.getKartennummer() + " ";
		result += this.getBetrag() + " ";
		return result;
	}
}
