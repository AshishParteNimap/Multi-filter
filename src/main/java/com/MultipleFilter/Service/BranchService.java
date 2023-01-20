package com.MultipleFilter.Service;

import java.util.List;

import com.MultipleFilter.Dto.BranchDto;

public interface BranchService {

	public List<BranchDto> getAllBranch();

	public String addBranch(BranchDto branchDto);

	public String deleteBranch(Long id);

	public String updateBranch(BranchDto branchDto, Long id);
}
