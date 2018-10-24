//package com.rs.hibernate.firstlevelcache.client;
//
//import java.util.Arrays;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import com.rs.hibernate.domain.Department;
//import com.rs.hibernate.domain.Employee;
//import com.rs.hibernate.util.HibernateUtil;
//
///**
// * @author ramesh
// * @version 1.0
// * @since 2018-10-23
// */
//public class SaveDepartmentAndEmployee {
//	public static void main(String[] args) {
//		Transaction tx = null;
//		try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); Session session = sessionFactory.openSession()) {
//			tx = session.beginTransaction();
//			Department department = new Department();
//			department.setName("Sales");
//			Employee emp1 = new Employee();
//			emp1.setEmpno(1000);
//			emp1.setName("Ramesh");
//			emp1.setEmail("ramesh@test.com");
//			emp1.setAge(23);
//			emp1.setSalary(25000.0f);
//			emp1.setDepartment(department);
//			Employee emp2 = new Employee();
//			emp2.setEmpno(1001);
//			emp2.setName("Kiran");
//			emp2.setEmail("kiran@test.com");
//			emp2.setAge(35);
//			emp2.setSalary(60000.0f);
//			emp2.setDepartment(department);
//			department.setEmployees(Arrays.asList(emp1, emp2));
//			session.save(department);
//			tx.commit();
//			System.out.println("Department and Employees saved");
//		} catch(HibernateException he) {
//			if(tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//			he.printStackTrace();
//		}
//	}
//}
