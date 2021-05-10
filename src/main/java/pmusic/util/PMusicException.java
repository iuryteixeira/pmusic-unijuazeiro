package pmusic.util;

public class PMusicException extends RuntimeException {

	private Integer code;

	public PMusicException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

}
