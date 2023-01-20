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

import com.MultipleFilter.Dto.DepartmentDto;
import com.MultipleFilter.Exception.ResponseDto;
import com.MultipleFilter.ServiceImpl.DepartmentServiceImpl;

@RestController
@RequestMapping("/department")
public class DepartementController {

	@Autowired
	private DepartmentServiceImpl impl;

	@GetMapping()
	public List<DepartmentDto> departmentDtos() {
		return impl.getAllDepartment();
	}

	@PostMapping()
	public ResponseEntity<?> addDepartment(@Valid @RequestBody DepartmentDto dto) {
		try {
			impl.addDepartment(dto);
			return new ResponseEntity<>("departement added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(e.getMessage(), "canot add department"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editDepartment(@Valid @RequestBody DepartmentDto dto, @PathVariable Long id) {
		try {
			impl.updateDepartment(dto, id);
			return new ResponseEntity<>("departement updated", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(e.getMessage(), "canot add department"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		impl.deleteDepartment(id);
		return "deprtment deleted";
	}
}
