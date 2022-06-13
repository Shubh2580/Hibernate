package in.co.rays.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.person.Address;
import in.co.rays.person.Employee;

public class TestPerson {
	public static void main(String[] args) {

		Address add1 = new Address();
		add1.setCity("Indore");
		add1.setState("MP");
		add1.setStreet("MG Road");

		Employee emp1 = new Employee();
		emp1.setFirstName("Adarsh");
		emp1.setLastName("Sharda");
		emp1.setEmpAddress(add1);

		Address add2 = new Address();
		add2.setCity("Kanpur");
		add2.setState("UP");
		add2.setStreet("Vidya Nagar");

		Employee emp2 = new Employee();
		emp2.setFirstName("Ayush");
		emp2.setLastName("Sharma");
		emp2.setEmpAddress(add2);

		Address add3 = new Address();
		add3.setCity("Mumbai");
		add3.setState("Maharashtra");
		add3.setStreet("Shree Ram Nagar");

		Employee emp3 = new Employee();
		emp3.setFirstName("Mohit");
		emp3.setLastName("Soni");
		emp3.setEmpAddress(add3);
		
		
		Address add4 = new Address();
		add4.setCity("Chennai");
		add4.setStreet("Jail Road");
		add4.setState("TamilNadu");
		
		Employee emp4= new  Employee();
		emp4.setFirstName("Ashish");
		emp4.setLastName("Shah");
		emp4.setEmpAddress(add4);

		List<Employee> list = new ArrayList<Employee>();

		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			Transaction t = s.beginTransaction();
			s.save(employee);
			t.commit();

		}

		s.close();
	}
}

