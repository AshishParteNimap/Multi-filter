package com.MultipleFilter.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultipleFilter.Dto.EmployeeDto;
import com.MultipleFilter.Entity.Employee;
import com.MultipleFilter.Repository.EmployeeRepository;
import com.MultipleFilter.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = repository.findAll();
		return employees
				.stream().map(em -> new EmployeeDto(em.getName(), em.getEmail(), em.getMobile(), em.getSalary(),
						em.getAddress(), em.getPincode(), em.getBranch(), em.getDepartment(), em.getDesignation()))
				.toList();
		// .collect(Collectors.toList());
	}

	@Override
	public String addEmployee(EmployeeDto dto) {

		Employee employee = new Employee();
		employee.setName(dto.getName());
		employee.setEmail(dto.getEmail());
		employee.setAddress(dto.getAddress());
		employee.setMobile(dto.getMobile());
		employee.setSalary(dto.getSalary());
		employee.setPincode(dto.getPincode());
		employee.setBranch(dto.getBranch());
		employee.setDepartment(dto.getDepartment());
		employee.setDesignation(dto.getDesignation());
		repository.save(employee);
		return "employee added";
	}

	@Override
	public String deleteEmployee(Long id) {

		Employee employee = repository.findById(id).orElse(null);
		repository.delete(employee);
		return "employee deleted";
	}

	@Override
	public String updateEmployee(EmployeeDto dto, Long id) {
		Employee employee = repository.findById(id).orElse(null);
		employee.setName(dto.getName());
		employee.setEmail(dto.getEmail());
		employee.setSalary(dto.getSalary());
		employee.setAddress(dto.getAddress());
		employee.setMobile(dto.getMobile());
		employee.setPincode(dto.getPincode());
		employee.setBranch(dto.getBranch());
		employee.setDepartment(dto.getDepartment());
		employee.setDesignation(dto.getDesignation());
		repository.save(employee);
		return "employee updated";
	}

	public List<Employee> findByDepartmentIdAndBranchIdAndDesignationId(List<Integer> departmentId,
			List<Integer> branchId, List<Integer> designationId) {
		return repository.findByDepartmentIdAndBranchIdAndDesignationId(departmentId, branchId, designationId);
	}

	@Override
	public List<Employee> search(String search) {

		return repository.searchEmp(search);
	}

}
