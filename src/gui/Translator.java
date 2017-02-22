package gui;

import fehlermeldung.EnumErrorCode;

public class Translator {

	public String translate(EnumErrorCode errorCode)
	{
		switch (errorCode) {
		case CardNumberNotFoundInDB:
			return "Der Betrag konnte nicht ausgezahlt werden, da Sie zu wenig Geld auf Ihrem Konto haben!";
		}
		
		throw new RuntimeException("Errorcode not found: " + errorCode);
	}
	
}
