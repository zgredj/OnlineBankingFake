package datenbank;

public class Zahlungen {
	double betragAuszahlen = 0;
	double betragEinzahlen = 0;
	String auszahlungPasswort = "";
	String einzahlungPasswort = "";

	public double getBetragAuszahlen() {
		return betragAuszahlen;
	}

	public void setBetragAuszahlen(double betragAuszahlen) {
		this.betragAuszahlen = betragAuszahlen;
	}

	public double getBetragEinzahlen() {
		return betragEinzahlen;
	}

	public void setBetragEinzahlen(double betragEinzahlen) {
		this.betragEinzahlen = betragEinzahlen;
	}

	public String getAuszahlung() {
		return auszahlungPasswort;
	}

	public void setAuszahlung(String auszahlung) {
		this.auszahlungPasswort = auszahlung;
	}

	public String getEinzahlung() {
		return einzahlungPasswort;
	}

	public void setEinzahlung(String einzahlung) {
		this.einzahlungPasswort = einzahlung;
	}
	
	public String toString() {
		String result = "";
		result += this.betragAuszahlen + " \n";
		result += this.betragEinzahlen + " \n";
		result += this.auszahlungPasswort + " \n";
		result += this.einzahlungPasswort;
		return result;
	}
}
