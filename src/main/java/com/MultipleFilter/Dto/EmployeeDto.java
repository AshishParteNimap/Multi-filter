package com.MultipleFilter.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.MultipleFilter.Entity.Branch;
import com.MultipleFilter.Entity.Department;
import com.MultipleFilter.Entity.Designation;

public class EmployeeDto {

	@NotBlank(message = "name should not be blank *name required")
	@NotEmpty(message = "name should not be empty or blank *name required")
	private String name;

	@NotBlank(message = "email should not be blank *email required")
	private String email;

	@NotNull(message = "mobile should not be null *mobile required")
	private Long mobile;

	@NotNull(message = "salary should not be null *salary required")
	private Long salary;

	@NotBlank(message = "address should not be blank *address required")
	private String address;

	@NotNull(message = "pincode should not be null *pincode required")
	private Long pincode;

	@NotNull(message = "branch should not be null *branch requied")
	private Branch branch;

	@NotNull(message = "department should not be null *department required")
	private Department department;

	@NotNull(message = "designation should not be null *designation required")
	private Designation designation;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(String name, String email, Long mobile, Long salary, String address, Long pincode, Branch branch,
			Department department, Designation designation) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.salary = salary;
		this.address = address;
		this.pincode = pincode;
		this.branch = branch;
		this.department = department;
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public void ListName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void ListEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void ListMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Long getSalary() {
		return salary;
	}

	public void ListSalary(Long salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void ListAddress(String address) {
		this.address = address;
	}

	public Long getPincode() {
		return pincode;
	}

	public void ListPincode(Long pincode) {
		this.pincode = pincode;
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
