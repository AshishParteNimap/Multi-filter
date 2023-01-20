package com.MultipleFilter.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MultipleFilter.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM Employee e WHERE e.department_id in :departmentId and e.branch_id in :branchId and e.designation_id in :designationId", nativeQuery = true)
	List<Employee> findByDepartmentIdAndBranchIdAndDesignationId(@Param("departmentId") List<Integer> departmentId,
			@Param("branchId") List<Integer> branchId,

			@Param("designationId") List<Integer> designationId);

	@Query(value = "SELECT * FROM Employee e WHERE e.name LIKE %:search% or e.email LIKE %:search% or e.address LIKE %:search% or e.mobile LIKE %:search% or e.salary LIKE %:search% ", nativeQuery = true)
	List<Employee> searchEmp(@Param("search") String search);

}
