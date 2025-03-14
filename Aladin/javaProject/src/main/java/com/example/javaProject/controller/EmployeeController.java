package com.example.javaProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaProject.model.Employee;
import com.example.javaProject.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/getEmployee")
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee emp) {
		return empRepo.save(emp);
	}
	
	@GetMapping("/getEmployeeBasedOnId/{id}")
	public ResponseEntity<Optional<Employee>>getEmployeeBasedOnId(@PathVariable int id) {
		Optional<Employee> emp = empRepo.findById(id);
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		Optional<Employee> updateEmployee =  empRepo.findById(id);
		updateEmployee(5, emp);
		empRepo.save(updateEmployee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
		Optional<Employee> emp = empRepo.findById(id);
		empRepo.deleteById(emp);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
