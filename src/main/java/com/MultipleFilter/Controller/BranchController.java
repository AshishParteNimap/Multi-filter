package com.MultipleFilter.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MultipleFilter.Dto.BranchDto;
import com.MultipleFilter.Exception.ResponseDto;
import com.MultipleFilter.ServiceImpl.BranchServiceImpl;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchServiceImpl impl;

	@GetMapping()
	public List<BranchDto> getAllBranch() {
		return impl.getAllBranch();

	}

	@PostMapping()
	public ResponseEntity<?> addBranch(@Valid @RequestBody BranchDto dto) {
		try {
			impl.addBranch(dto);
			return new ResponseEntity<>("branch added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(e.getMessage(), "canot add branch"), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editBranch(@Valid @RequestBody BranchDto dto, @PathVariable Long id) {
		try {
			impl.updateBranch(dto, id);

			return new ResponseEntity<>("brnach edited", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(e.getMessage(), "canot edit branch"), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public String deleteBranch(@PathVariable Long id) {
		impl.deleteBranch(id);
		return "branch deleted";
	}
}
