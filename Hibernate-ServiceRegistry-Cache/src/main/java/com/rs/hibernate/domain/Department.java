package com.rs.hibernate.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

/*
 	none : No caching will happen.
    read-only : If your application needs to read, but not modify, instances of a persistent class, a read-only cache can be used.
    read-write : If the application needs to update data, a read-write cache might be appropriate.
    nonstrict-read-write : If the application only occasionally needs to update data (i.e. if it is extremely unlikely that two transactions would try to update the same item simultaneously), and strict transaction isolation is not required, a nonstrict-read-write cache might be appropriate.
    transactional : The transactional cache strategy provides support for fully transactional cache providers such as JBoss TreeCache. Such a cache can only be used in a JTA environment and you must specify hibernate.transaction.manager_lookup_class.
 */
//https://github.com/kishanjavatrainer/HibernateQueryAndCollectionCacheExample/blob/master/HibernateQueryAndCollectionCacheExample/src/main/java/com/infotech/entities/Employee.java
/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-23
 */
@Entity
//@Table(name = "department", uniqueConstraints= {
//		@UniqueConstraint(columnNames = "id"),
//		@UniqueConstraint(columnNames = "name")
//})
@Table(name = "department")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department implements Serializable {
	private static final long serialVersionUID = -3840137040352623651L;
	private int id;
	private String name;
	private List<Employee> employees;

	@Id
	@SequenceGenerator(name = "DEPARTMENT_ID_GEN", sequenceName = "DEPARTMENT_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "DEPARTMENT_ID_GEN", strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, unique = true)
	@Type(type = "string")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * By default collection data will not be cached by hibernate you have to enable by 
	 * @Cache annotation.
	 */
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
}
