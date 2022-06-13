package in.co.rays.inheritance3;

public class Cheque extends Payment {

	private int chqnumber;
	private String bankname;
	private int PaymentId;
	
	public Cheque() {
		// TODO Auto-generated constructor stub
	}

	public int getChqnumber() {
		return chqnumber;
	}

	public void setChqnumber(int chqnumber) {
		this.chqnumber = chqnumber;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public int getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(int paymentId) {
		PaymentId = paymentId;
	}

}
