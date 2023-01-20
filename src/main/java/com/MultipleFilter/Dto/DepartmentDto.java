package com.MultipleFilter.Dto;

import javax.validation.constraints.NotBlank;

public class DepartmentDto {

	@NotBlank(message = "departmentName shuld not be blank #departmentName required")
	private String departmentName;

	public DepartmentDto() {
		super();
	}

	public DepartmentDto(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
