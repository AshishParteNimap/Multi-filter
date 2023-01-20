package com.MultipleFilter.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class DesignationDto {

	@NotBlank(message = "designation should not be blank *designation required")
	@NotEmpty(message = "designation should not be empty or blank *designation required")
	private String designation;

	public DesignationDto() {
		super();

	}

	public DesignationDto(String designation) {
		super();
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
