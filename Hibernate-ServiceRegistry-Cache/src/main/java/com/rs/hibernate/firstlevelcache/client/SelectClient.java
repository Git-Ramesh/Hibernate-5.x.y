package com.rs.hibernate.firstlevelcache.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rs.hibernate.domain.Employee;
import com.rs.hibernate.util.HibernateUtil;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-23
 */
public class SelectClient {

	public static void main(String[] args) {
		Transaction tx = null;

		try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
			Session session = sessionFactory.openSession();
//			tx = session.beginTransaction();
			Employee employee = session.get(Employee.class, 1);
			//Here employee returned from session level cache
			Employee employee2 =session.get(Employee.class, 1); 
			System.out.println(employee);
			System.out.println(employee);
//			tx.commit();
		} catch (HibernateException hibernateException) {
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
			hibernateException.printStackTrace();
		}
	}
}
