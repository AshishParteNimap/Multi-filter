package com.MultipleFilter.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MultipleFilter.Dto.EmployeeDto;
import com.MultipleFilter.Entity.Employee;
import com.MultipleFilter.Exception.ResponseDto;
import com.MultipleFilter.ServiceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
@Validated
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping()
	public List<EmployeeDto> getAll() {
		return service.getAllEmployee();
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(
			@RequestParam(value = "departmentId", required = true) List<Integer> departmentId,
			@RequestParam(value = "branchId", required = true) List<Integer> branchId,
			@RequestParam(value = "designationId", required = true) List<Integer> designationId) {
		List<Employee> employees = service.findByDepartmentIdAndBranchIdAndDesignationId(departmentId, branchId,
				designationId);
		if (employees.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto dto) {
		try {
			service.addEmployee(dto);
			return new ResponseEntity<>("employee added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(e.getMessage(), "employee not added"), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editEmployee(@RequestBody EmployeeDto dto, @PathVariable Long id) {
		try {
			service.updateEmployee(dto, id);
			return new ResponseEntity<>("employee added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(e.getMessage(), "canot update employee"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return new ResponseEntity<>("employee deletd", HttpStatus.OK);

	}

	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam(value = "search") String search) {

		List<Employee> employee = service.search(search);
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}

}
