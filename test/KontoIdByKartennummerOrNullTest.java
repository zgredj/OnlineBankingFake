package test;
import org.junit.Assert;
import org.junit.Test;

import datenbank.DatenbankCode;

public class KontoIdByKartennummerOrNullTest{

	@Test
	public void test() {
		int expectedKontoID = 1;
		int actualKontoID;
		int kartennummer = 42;
		
		actualKontoID = DatenbankCode.getKontoIdByKartennummerOrNull(kartennummer);
		
		Assert.assertEquals(expectedKontoID, actualKontoID);
		
		
		
	}

}
