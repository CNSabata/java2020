package aliptic.java.services.exceptions;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7248288067662287210L;
	private String code;
	public ProductNotFoundException(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
}
