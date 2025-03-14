package com.example.javaProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaProject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	void deleteById(Optional<Employee> emp);

	void save(Optional<Employee> updateEmployee);

	

}
