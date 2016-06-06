
public class RegisterState {

	private int value;
	private boolean underOperation;
	
	public RegisterState(int value, boolean underOperation){
		
		this.value = value;
		this.underOperation = underOperation;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isUnderOperation() {
		return underOperation;
	}

	public void setUnderOperation(boolean underOperation) {
		this.underOperation = underOperation;
	}
	
}
