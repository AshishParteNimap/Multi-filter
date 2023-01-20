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
@Table(name = "Branch")
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String Branch;

	@JsonIgnore
	@OneToMany(mappedBy = "branch")
	private List<Employee> employee;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(Long id, String branch, List<Employee> employee) {
		super();
		this.id = id;
		Branch = branch;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void ListId(Long id) {
		this.id = id;
	}

	public String getBranch() {
		return Branch;
	}

	public void ListBranch(String branch) {
		Branch = branch;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void ListEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}
