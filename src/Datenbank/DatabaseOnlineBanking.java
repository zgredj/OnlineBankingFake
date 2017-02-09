package Datenbank;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseOnlineBanking {

	public static void main(String[] args) {

		Connection con = ConnectionFactory.getInstance().getConnection();

//		try {
//
//			KontoJDBCDao kd = new KontoJDBCDao(con);
//
//			Konto k = new Konto();
//			for (int i = 0; i < 10; i++) {
//				k.setName("Kappeler");
//				k.setVorname("Andrin");
//				k.setGeburtsdatum("06.03.2000");
//				k.setKartennummer(324);
//				k.setPasswort("DiesIstEinPasswort");
//				k.setKontostand(5000.50);
//			}
//
//			kd.insertKonto(k);
//
//			for (Konto konto : kd.getAllKonten()) {
//				System.out.println(konto.toString());
//			}
//		} catch (Exception exc) {
//			exc.printStackTrace();
//		}

		try {

			AdresseJDBCDao ad = new AdresseJDBCDao(con);
			Adresse a = new Adresse();
			for (int i = 0; i < 10; i++) {
				a.setStrasse("Schulhausstrasse");
				a.setHausnummer(5);
				a.setWohnort("KP");
				a.setPlz(8182);
				a.setEmail("meine.email@hier.com");
			}

			ad.insertAdresse(a);

			for (Adresse adresse : ad.getAllAdressen()) {
				System.out.println(adresse.toString());
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		// try {
		//
		// RechnungJDBCDao rd = new RechnungJDBCDao(con);
		// Rechnung r = new Rechnung();
		// for (int i = 0; i < 10; i++) {
		// r.setKartennummer(123);
		// r.setBetrag(100.50);
		// }
		//
		// rd.insertRechnung(r);
		//
		// for (Rechnung rechnung : rd.getAllRechnungen()) {
		// System.out.println(rechnung.toString());
		// }
		// } catch (Exception exc) {
		// exc.printStackTrace();
		// } finally {
		// try {
		// con.close();
		// } catch (SQLException sqlexc) {
		// sqlexc.printStackTrace();
		// }
		// }
	}
}
