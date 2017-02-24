package JUnitTestfaelle;

import org.junit.Assert;
import org.junit.Test;

import datenbank.DatenbankCode;
import datenbank.Konto;

public class DatenbankCodeTest {

	@Test
	public void testGetVorUndNachnameVonDatenbankByKartennummer() {
		int existierendeKartennummer = 1;
		String expectedVorname = "Andrin";
		String expectedNachname = "Kappeler";
		
		Konto k = DatenbankCode.getVorUndNachnameVonDatenbankByKartennummer(existierendeKartennummer);
		
		Assert.assertNotNull(k);
		Assert.assertEquals(expectedVorname, k.getVorname());
		Assert.assertEquals(expectedNachname, k.getName());
		
	}
}
