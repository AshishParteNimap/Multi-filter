package com.MultipleFilter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MultipleFilter.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
