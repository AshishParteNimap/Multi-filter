package com.MultipleFilter.Dto;

import javax.validation.constraints.NotBlank;

public class BranchDto {

	@NotBlank(message = "branch should be blank * branch required")
	private String branch;

	public BranchDto() {
		super();
	}

	public BranchDto(String branch) {
		super();
		this.branch = branch;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
