/**
 * 
 */
package com.rs.hibernate.secondlevel.cache.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rs.hibernate.domain.Department;
import com.rs.hibernate.util.HibernateUtil;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-24
 */
public class L2CacheTest {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session1 = factory.openSession();
		Department dept1 = (Department) session1.get(Department.class, 7);
//		System.out.println(dept1.getId() + " " + dept1.getName());
		System.out.println(dept1);
		session1.evict(dept1);
		
		session1.close();

		Session session2 = factory.openSession();
		Department dept2 = (Department) session2.get(Department.class, 7);
		System.out.println(dept2);
//		System.out.println(dept2.getId() + " " + dept2.getName());
		session2.close();

	}
}
