package shop.apotheke.assessment.exception;

public class ShopApothekeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 509266030859096465L;

	public ShopApothekeException() {
		super();
	}

	public ShopApothekeException(String message) {
		super(message);
	}

	public ShopApothekeException(String message, Throwable cause) {
		super(message, cause);
	}
}
