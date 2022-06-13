package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.bean.CachePOJO;

public class TestCache {

	public static void main(String[] args) {
		 //testAdd();
		// testList();//QueryCache
		// testGet();//first level cache
		// testGet1();//first level cache evict()
		// testGet2();//first level cache clear()
		// testGet3();//first level cache session()
		//testGet4();// second level cache
		testGet5();

	}

	private static void testGet5() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
	
		
		Query query =s.getNamedQuery("allUser");

		 List<CachePOJO> list =query.list();
		Iterator<CachePOJO> it = list.iterator();
		CachePOJO cp;
		while (it.hasNext()) {

			cp = (CachePOJO) it.next();
			System.out.println("id:"+cp.getId());
			System.out.println("name:"+cp.getName());

		}
		
		 s.close();

		
	}

	private static void testGet4() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("got values from the table");
		CachePOJO cp = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp.getId());
		System.out.println(cp.getName());
		s.close(); 
		Session s1 = sf.openSession();
		CachePOJO cp1 = (CachePOJO) s1.get(CachePOJO.class, 1);
		System.out.println(cp1.getId());
		System.out.println(cp1.getName());
		s1.close();

	}

	private static void testGet3() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("got values from the table");
		CachePOJO cp = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp.getId());
		System.out.println(cp.getName());
		s.close();
		CachePOJO cp1 = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp1.getId());
		System.out.println(cp1.getName());
		s.close();

	}

	private static void testGet2() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("got values from the table");
		CachePOJO cp = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp.getId());
		System.out.println(cp.getName());
		s.clear();
		CachePOJO cp1 = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp1.getId());
		System.out.println(cp1.getName());
		s.clear();

	}

	private static void testGet() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		// System.out.println("got values from the table");
		CachePOJO cp = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp.getId());
		System.out.println(cp.getName());

		CachePOJO cp1 = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp1.getId());
		System.out.println(cp1.getName());

	}

	private static void testGet1() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		// System.out.println("got values from the table");
		CachePOJO cp = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp.getId());
		System.out.println(cp.getName());
		s.evict(cp);
		
		  CachePOJO cp1 = (CachePOJO) s.get(CachePOJO.class, 1);
		  System.out.println(cp1.getId()); System.out.println(cp1.getName());
		  s.evict(cp1);
		 

	}

	private static void testAdd() {
		CachePOJO cp = new CachePOJO();
//cp.setId(1);
		cp.setName("Shubham");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(cp);
		t.commit();
		s.close();
		System.out.println("added");

	}

	private static void testList() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("from CachePOJO");

		List<CachePOJO> li = q.list();
		Iterator<CachePOJO> it = li.iterator();
		CachePOJO cp;
		while (it.hasNext()) {

			cp = (CachePOJO) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getName());

		}

		s.close();

	}

}
