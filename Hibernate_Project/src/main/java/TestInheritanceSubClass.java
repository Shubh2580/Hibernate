import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.inheritance2.CashSubClass;
import in.co.rays.inheritance2.ChequeSubClass;
import in.co.rays.inheritance2.CreditSubClass;

public class TestInheritanceSubClass {
public static void main(String[] args) {
		
		CreditSubClass cre = new CreditSubClass();
		cre.setPaymentId(9);
		cre.setAmount(20000);
		cre.setCcType("visa");
		
		CashSubClass ca=new CashSubClass();
		ca.setPaymentId(10);
		ca.setAmount(30000);
	
		
		ChequeSubClass che=new ChequeSubClass();
		che.setPaymentId(11);
		che.setAmount(40000);
		che.setChqNumber(234567);
		che.setBankName("SBI");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(cre);
		s.save(ca);
		s.save(che);

		t.commit();
		s.close();
		System.out.println("added");
	}


}
