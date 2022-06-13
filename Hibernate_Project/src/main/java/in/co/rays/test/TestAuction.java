package in.co.rays.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.association.Auction;
import in.co.rays.association.Bid;

public class TestAuction {
public static void main(String[] args) {
	
	Auction item= new Auction();
	item.setDescr("Audi");
	
	Bid bid1 = new Bid();
	bid1.setAmount(500);
	
	Bid bid2= new Bid();
	bid2.setAmount(700);
	
	Bid bid3= new Bid();
	bid3.setAmount(900);
	
	Set<Bid> set= new HashSet<>();
	set.add(bid1);
	set.add(bid2);
	set.add(bid3);
	
	item.setBids(set);
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session s = sf.openSession();
	Transaction t = s.beginTransaction();
	s.save(item);
	t.commit();
	s.close();

	
}
}
