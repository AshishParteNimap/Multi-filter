package com.MultipleFilter.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultipleFilter.Dto.BranchDto;
import com.MultipleFilter.Entity.Branch;
import com.MultipleFilter.Repository.BranchRepository;
import com.MultipleFilter.Service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository repository;

	@Override
	public List<BranchDto> getAllBranch() {
		List<Branch> branch = repository.findAll();
		List<BranchDto> dto = branch.stream().map(br -> new BranchDto(br.getBranch())).collect(Collectors.toList());

		return dto;
	}

	@Override
	public String addBranch(BranchDto branchDto) {
		Branch branch = new Branch();
		branch.ListBranch(branchDto.getBranch());
		repository.save(branch);
		return "branch added";
	}

	@Override
	public String deleteBranch(Long id) {

		Branch branch = repository.findById(id).orElse(null);
		repository.delete(branch);
		return "branch deleted";
	}

	@Override
	public String updateBranch(BranchDto branchDto, Long id) {

		Branch branch = repository.findById(id).orElse(null);
		branch.ListBranch(branchDto.getBranch());
		repository.save(branch);
		return "branch updated";
	}

}
