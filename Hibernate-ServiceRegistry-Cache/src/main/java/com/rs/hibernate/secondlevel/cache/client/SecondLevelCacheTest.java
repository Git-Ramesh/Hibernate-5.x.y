package com.rs.hibernate.secondlevel.cache.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rs.hibernate.domain.Department;
import com.rs.hibernate.util.HibernateUtil;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-24
 */
public class SecondLevelCacheTest {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public static void main(String[] args) {
		try (Session session = sessionFactory.openSession()) {
			Department department = session.get(Department.class, 7);
			System.out.println(department);
			// Get the object from database and put in Session cache
			department = session.get(Department.class, 7);
			System.out.println(department);

			session.evict(department);
			System.out.println("Object Evicted");
			// This will work when CacheConcurrencyStrategy.READ_ONLY
			// Get the object form SessionFactory level cache
			department = session.get(Department.class, 7);
			System.out.println(department);
			session.clear();
		} catch (HibernateException hex) {
			hex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}
}
