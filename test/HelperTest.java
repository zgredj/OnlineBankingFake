import org.junit.Assert;
import org.junit.Test;

import util.Helper;

public class HelperTest {

	@Test
	public void testCheckDigitReturnIntOrNegativError_OK() {
		String input = "5";
		int expectedOutput = 5;
		
		int result = Helper.checkDigitReturnIntOrNegativError(input);
		Assert.assertEquals(expectedOutput, result);
	}
	
	@Test
	public void testCheckDigitReturnIntOrNegativError_NOK() {
		String input = "Hallo";
		int expectedOutput = -1;
		
		int result = Helper.checkDigitReturnIntOrNegativError(input);
		Assert.assertEquals(expectedOutput, result);
	}
	

	@Test
	public void testCheckDigitReturnIntOrNegativError_NOK_2() {
		String input = "5 ";
		int expectedOutput = -1;
		
		int result = Helper.checkDigitReturnIntOrNegativError(input);
		Assert.assertEquals(expectedOutput, result);
	}
	
	@Test
	public void testCheckDigitReturnIntOrNegativError_NOK_3() {
		String input = "3.4";
		int expectedOutput = -1;
		
		int result = Helper.checkDigitReturnIntOrNegativError(input);
		Assert.assertEquals(expectedOutput, result);
	}

}
