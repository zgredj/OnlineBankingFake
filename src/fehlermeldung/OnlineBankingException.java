package fehlermeldung;

public class OnlineBankingException extends RuntimeException {

	private EnumErrorCode errorCode;

	public OnlineBankingException(EnumErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public EnumErrorCode getErrorCode() {
		return errorCode;
	}

}
