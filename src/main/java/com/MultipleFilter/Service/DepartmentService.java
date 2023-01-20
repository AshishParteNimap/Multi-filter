package com.MultipleFilter.Service;

import java.util.List;

import com.MultipleFilter.Dto.DepartmentDto;

public interface DepartmentService {

	public List<DepartmentDto> getAllDepartment();

	public String addDepartment(DepartmentDto departmentDto);

	public String deleteDepartment(Long id);

	public String updateDepartment(DepartmentDto departmentDto, Long id);

}
