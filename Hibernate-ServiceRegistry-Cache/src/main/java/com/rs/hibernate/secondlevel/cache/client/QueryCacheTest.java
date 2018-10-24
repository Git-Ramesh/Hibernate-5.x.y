package com.rs.hibernate.secondlevel.cache.client;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.rs.hibernate.domain.Department;
import com.rs.hibernate.util.HibernateUtil;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-24
 */
public class QueryCacheTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session ses1 = null;
		try {
			ses1=sessionFactory.openSession();
			Query<Department> query = ses1.createQuery("from Department", Department.class);
			query.setCacheable(true);
			List<Department> list = query.list();
//			System.out.println(list.size());
//			System.out.println(list);
			list.forEach(System.out::println);
		} catch(HibernateException hex) {
			hex.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ses1.close();
		}
		
		try {
			ses1=sessionFactory.openSession();
			Query<Department> query = ses1.createQuery("from Department", Department.class);
			query.setCacheable(true);
			List<Department> list = query.list();
//			System.out.println(list.size());
//			System.out.println(list);
			list.forEach(System.out::println);
		} catch(HibernateException hex) {
			hex.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ses1.close();
		}
	}
}
