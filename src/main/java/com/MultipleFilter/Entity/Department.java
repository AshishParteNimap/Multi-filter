package com.MultipleFilter.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String departmentName;

	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<Employee> employee;

	public Department(Long id, String departmentName, List<Employee> employee) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.employee = employee;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void ListEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void ListId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void ListDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
