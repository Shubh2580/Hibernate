package in.co.rays.inheritance3;

public class CreditCard extends Payment {
	private int PaymentId;
	private String cc_type;
	public CreditCard() {
		// TODO Auto-generated constructor stub
	}
	public int getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(int paymentId) {
		PaymentId = paymentId;
	}
	public String getCctype() {
		return cc_type;
	}
	public void setCctype(String cctype) {
		this.cc_type = cctype;
	}
	
}
