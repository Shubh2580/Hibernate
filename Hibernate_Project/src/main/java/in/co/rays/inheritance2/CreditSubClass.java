package in.co.rays.inheritance2;

public class CreditSubClass extends PaymentSubclass {
private String ccType;
	
	public CreditSubClass() {
		
	}
	public String getCcType() {
		return ccType;
	}
	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
	
}
