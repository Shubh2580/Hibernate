package in.co.rays.test;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import in.co.rays.inheritance3.Cheque;
import in.co.rays.inheritance3.CreditCard;

public class TestInheritance {

	public static void main(String[] args) {

		CreditCard card = new CreditCard();
		card.setId(10);
		card.setAmount(10000);
		card.setPaymenttype("Rupay");

		Cheque cheq = new Cheque();
		cheq.setId(9);
		cheq.setAmount(250000);
		cheq.setChqnumber(5896320);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction txn = s.beginTransaction();
		s.save(cheq);
		s.save(card);

		txn.commit();
		s.close();

		System.out.println("Verified");

	}
}