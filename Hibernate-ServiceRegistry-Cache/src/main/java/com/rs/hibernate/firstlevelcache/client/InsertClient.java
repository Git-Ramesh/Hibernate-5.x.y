package com.rs.hibernate.firstlevelcache.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rs.hibernate.domain.Employee;
import com.rs.hibernate.util.HibernateUtil;

public class InsertClient {
	public static void main(String[] args) {
		Transaction tx = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEmpno(1000);
			employee.setName("Ramesh");
			employee.setAge(23);
			employee.setSalary(25000.0f);
			employee.setEmail("rameshpanthangi08@gmail.com");
			Integer id = (Integer) session.save(employee);
			System.out.println("ID: " + id);
			tx.commit();
			System.out.println("Employee Saved.");
			session.close();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}
}
