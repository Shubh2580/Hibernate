package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.bean.User;

public class TestUser {
	public static void main(String[] args) throws Exception {
		 //testAdd();
		// testUpdate();
		// testDelete();
		 testGet();
		// testList();
		// testSingleColumn();
		// testMultiColumn1();
		// testLike();
		// testOrderBy();
		// testAggre();
		//authenticate("nisha.mehta", "5678");
		 

	}

	public static User authenticate(String login, String pwd) throws Exception {

		User u = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from User where username=? and password=?");
		q.setString(0, login);
		q.setString(1, pwd);
		List li = q.list();
		if (li.size() == 1) {
			u = (User) li.get(0);
			System.out.println(u.getLname());
			System.out.println("User is valid....!!!");

		} else {
			System.out.println("Invalid user....!!!");
		}
		s.close();
		return u;

	}

	private static void testAggre() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("select count(*) from User");
		List li = q.list();
		Iterator it = li.iterator();

		Integer i = (Integer) li.get(0);
		System.out.println(i);
	}

	private static void testLike() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from User where fname like '%a'");
		List li = q.list();
		Iterator it = li.iterator();
		User u;
		while (it.hasNext()) {
			u = (User) it.next();
			System.out.println(u.getId() + "\t" + u.getFname());

		}

	}

	private static void testOrderBy() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from User where fname like '%a' order by id ");
		List li = q.list();
		Iterator it = li.iterator();
		User u;
		while (it.hasNext()) {
			u = (User) it.next();
			System.out.println(u.getId() + "\t" + u.getFname());
		}
	}

	private static void testMultiColumn1() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("select u.id,u.fname from User u");

		List li = q.list();
		Iterator it = li.iterator();
		while (it.hasNext()) {
			Object[] u = (Object[]) it.next();
			System.out.println(u[0]);
			System.out.println(u[1]);

		}

	}

	private static void testMultiColumn() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("select u.id,u.fname from User u");

		List li = q.list();
		Iterator it = li.iterator();
		Object[] col;
		System.out.println("id \t name");
		while (it.hasNext()) {
			col = (Object[]) it.next();
			Integer id = (Integer) col[0];
			String fname = (String) col[1];

			System.out.println(id + "\t" + fname);
		}

		s.close();

	}

	private static void testSingleColumn() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("select u.fname from User u");

		List li = q.list();
		Iterator it = li.iterator();

		while (it.hasNext()) {

			String us = (String) it.next();

			System.out.println(us);
		}

		s.close();

	}

	private static void testAdd() {
		User u = new User();

		u.setFname("wasim");
		u.setLname("khan");
		u.setUserName("wasim.khan");
		u.setPassword("123456");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(u);
		t.commit();
		s.close();
		System.out.println("added");

	}

	private static void testUpdate() {
		User u = new User();
		u.setId(6);
		u.setFname("aarti");
		u.setLname("sharma");
		u.setUserName("aarti.sharma");
		u.setPassword("123457");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		s.update(u);

		t.commit();

		s.close();
		System.out.println("Updated");

	}

	private static void testDelete() {
		User u = new User();
		u.setId(6);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		s.delete(u);

		t.commit();

		s.close();
		System.out.println("Deleted");

	}

	private static void testGet() {
		//User u = new User();
		//u.setId(1);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		Query q= s.getNamedQuery("allUser");

		User u = (User) s.get(User.class, 1);
		// u=(User)s.load(User.class, 4);
		List l= q.list();
		Iterator<User> it= l.iterator();
		while (it.hasNext()) {

			u = it.next();

			System.out.println(u);
		
		
		  //System.out.println(u.getId() );
		 s.close();
		}
		 
	}

	private static void testList() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("from User");
		// Query q=s.createSQLQuery("select * from user");
		List<User> li = q.list();
		Iterator<User> it = li.iterator();
		User u;
		while (it.hasNext()) {
			u = (User) it.next();
			System.out.println(u.getId());
			System.out.println(u.getFname());
		}

		s.close();

	}

}
