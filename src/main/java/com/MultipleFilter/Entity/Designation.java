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
@Table(name = "Designation")
public class Designation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String Designation;

	@JsonIgnore
	@OneToMany(mappedBy = "designation")
	private List<Employee> employee;

	public Designation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Designation(Long id, String designation, List<Employee> employee) {
		super();
		this.id = id;
		Designation = designation;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void ListId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return Designation;
	}

	public void ListDesignation(String designation) {
		Designation = designation;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void ListEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
