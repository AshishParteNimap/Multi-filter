package com.MultipleFilter.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultipleFilter.Dto.DepartmentDto;
import com.MultipleFilter.Entity.Department;
import com.MultipleFilter.Repository.DepartmentRepository;
import com.MultipleFilter.Service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	@Override
	public List<DepartmentDto> getAllDepartment() {
		List<Department> departments = repository.findAll();
		List<DepartmentDto> dto = departments.stream().map(dp -> new DepartmentDto(dp.getDepartmentName()))
				.collect(Collectors.toList());

		return dto;
	}

	@Override
	public String addDepartment(DepartmentDto departmentDto) {
		Department department = new Department();
		department.ListDepartmentName(departmentDto.getDepartmentName());
		repository.save(department);
		return "departement added";
	}

	@Override
	public String deleteDepartment(Long id) {
		Department department = repository.findById(id).orElse(null);
		repository.delete(department);

		return "department deleted";
	}

	@Override
	public String updateDepartment(DepartmentDto departmentDto, Long id) {
		Department department = repository.findById(id).orElse(null);
		department.ListDepartmentName(departmentDto.getDepartmentName());
		repository.save(department);

		return "department updated";
	}

}
