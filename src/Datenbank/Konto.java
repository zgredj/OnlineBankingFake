package Datenbank;

public class Konto {

	int id;
	String name;
	String vorname;
	String geburtsdatum;
	int kartennummer;
	String passwort;
	double kontostand;
	int adresse_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public int getKartennummer() {
		return kartennummer;
	}

	public void setKartennummer(int kartennummer) {
		this.kartennummer = kartennummer;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

	public int getAdresse_id() {
		return adresse_id;
	}

	public void setAdresse_id(int adresse_id) {
		this.adresse_id = adresse_id;
	}

	public String toString() {
		String result = "";
		result += this.id + " ";
		result += this.name + " ";
		result += this.vorname + " ";
		result += this.geburtsdatum + " ";
		result += this.kartennummer + " ";
		result += this.passwort + " ";
		result += this.kontostand + " ";
		result += this.adresse_id + " ";
		return result;
	}
}
