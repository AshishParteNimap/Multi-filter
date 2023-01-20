package com.MultipleFilter.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Long salary;

	private String email;

	private String address;

	private Long pincode;

	private Long mobile;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Branch_id", referencedColumnName = "id")
	private Branch branch;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Department_id", referencedColumnName = "id")
	private Department department;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Designation_id", referencedColumnName = "id")
	private Designation designation;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String name, Long salary, String email, String address, Long pincode, Long mobile,
			Branch branch, Department department, Designation designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
		this.mobile = mobile;
		this.branch = branch;
		this.department = department;
		this.designation = designation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

}
