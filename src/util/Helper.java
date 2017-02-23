package util;

public class Helper {

	public static int checkDigitReturnIntOrNegativError(String uncheckedString) {
		int checkedInteger = -1;
		try {
			checkedInteger = Integer.parseInt(uncheckedString);
		} catch (NumberFormatException nfe) {
			return -1;
		}
		return checkedInteger;
	}
}
