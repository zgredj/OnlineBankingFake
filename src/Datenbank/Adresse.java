package Datenbank;

public class Adresse {
	int id;
	String strasse;
	String hausnummer;
	String wohnort;
	int plz;
	String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		String result = "";
		result += this.id + " ";
		result += this.strasse + " ";
		result += this.hausnummer + " ";
		result += this.wohnort + " ";
		result += this.plz + " ";
		result += this.email + " ";
		return result;
	}
}
