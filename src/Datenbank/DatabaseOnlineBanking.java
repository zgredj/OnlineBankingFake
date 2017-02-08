package Datenbank;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseOnlineBanking {

	public static void main(String[] args) {

		Connection con = ConnectionFactory.getInstance().getConnection();

		try {

			KontoJDBCDao kd = new KontoJDBCDao(con);

			Konto k = new Konto();
			for (int i = 0; i < 10; i++) {
				k.setName("Konto");
				k.setVorname("Andrin");
				k.setGeburtsdatum("06.03.2000");
				k.setKartennummer(324);
				k.setPasswort("DiesIstEinPasswort");
				k.setKontostand(5000.50);
			}

			kd.insertKonto(k);

			for (Konto konto : kd.getAllKontos()) {
				System.out.println(konto.toString());
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException sqlexc) {
				sqlexc.printStackTrace();
			}
		}
	}
}
