package phonbook;

public class ExistException extends Exception {
	public ExistException() {
		super("이미존재합니다.");
	}
}
