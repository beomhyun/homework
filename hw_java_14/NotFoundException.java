package phonbook;

public class NotFoundException extends Exception {
	public NotFoundException() {
		super("찾지못했습니다.");
	}
}
