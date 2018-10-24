package com.rs.hibernate.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

/**
 * @author ramesh
 * @version 1.0
 * @since 2018-10-23
 */

@Entity
@Table(name = "employee")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee implements Serializable {
	private static final long serialVersionUID = -3430177050288901059L;
	private Integer id;
	private Integer empno;
	private String name;
	private String email;
	private Integer age;
	private Float salary;
	private Department department;

	@Id
	@SequenceGenerator(name = "EMPLOYEE_ID_GEN", sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EMPLOYEE_ID_GEN")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "empno", length = 10, nullable = false, unique = true)
	@Type(type = "int")
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	@Column(name = "name", length = 30, nullable = false, unique = false)
	@Type(type = "string")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", length = 45, nullable = false, unique = true)
	@Type(type = "string")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "age", length = 3, nullable = true, unique = false)
	@Type(type = "int")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "salary", length = 15, nullable = true, unique = false)
	@Type(type = "float")
	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id", nullable = false)
	//Here default JoinColumn is department_id
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empno=" + empno + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", salary=" + salary + "]";
	}

}
