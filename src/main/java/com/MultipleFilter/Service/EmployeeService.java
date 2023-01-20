package com.MultipleFilter.Service;

import java.util.List;

import com.MultipleFilter.Dto.EmployeeDto;
import com.MultipleFilter.Entity.Employee;

public interface EmployeeService {

	public List<EmployeeDto> getAllEmployee();

	public String addEmployee(EmployeeDto dto);

	public String deleteEmployee(Long id);

	public String updateEmployee(EmployeeDto dto, Long id);

	public List<Employee> search(String search);
}
