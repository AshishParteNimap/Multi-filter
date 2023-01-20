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
import org.springframework.web.bind.annotation.RestController;

import com.MultipleFilter.Dto.DesignationDto;
import com.MultipleFilter.Exception.ResponseDto;
import com.MultipleFilter.ServiceImpl.DesignationServiceImpl;

@RestController
@RequestMapping("/desi")
@Validated
public class DesignatoinController {

	@Autowired
	private DesignationServiceImpl impl;

	@GetMapping()
	public List<DesignationDto> designation() {
		return impl.getAllDesignation();
	}

	@PostMapping()
	public ResponseEntity<?> addDesi(@Valid @RequestBody DesignationDto designationDto) {
		try {
			impl.addDesignation(designationDto);
			return new ResponseEntity<>("designation added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(e.getMessage(), "designation canot add"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping()
	public ResponseEntity<?> updateDesi(@RequestBody DesignationDto designationDto, @PathVariable Long id) {

		try {
			impl.updateDesignation(designationDto, id);
			return new ResponseEntity<>("designation upadated", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseDto(e.getMessage(), "canot update designation"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping()
	public String deleteDesignation(@PathVariable Long id) {
		impl.deleteDesignation(id);
		return "Designation deleted";
	}

}
