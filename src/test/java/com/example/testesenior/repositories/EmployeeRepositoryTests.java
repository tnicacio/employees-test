package com.example.testesenior.repositories;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.testesenior.dto.EmployeeDTO;
import com.example.testesenior.entities.Employee;
import com.example.testesenior.entities.Person;

@DataJpaTest
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private PersonRepository personRepository;
	
	private Person person1;
	private Person person2;
	private Person person3;
	private Employee currentEmployee;
	private Employee employeeDismissed;
	private Employee excludedEmployee;
	
	private LocalDateTime excludedHireDate = LocalDateTime.of(4000, 01, 01, 0, 0);
	private LocalDateTime excludedDismissalDate = LocalDateTime.of(1900, 01, 01, 0, 0);

	private LocalDateTime validHireDate = LocalDateTime.of(2020, 01, 01, 0, 0);
	private LocalDateTime validDismissalDate = LocalDateTime.of(2021, 01, 01, 0, 0);
	
	@BeforeEach
	void setUp() throws Exception {
		createPersons();
		createEmployees();
	}
	
	private void createPersons() {
		person1 = new Person(null, "João");
		person2 = new Person(null, "Maria");
		person3 = new Person(null, "Arnaldo");
		person1 = personRepository.save(person1);
		person2 = personRepository.save(person2);
		person3 = personRepository.save(person3);
	}
	
	private void createEmployees() {
		excludedEmployee = new Employee(null, excludedHireDate, excludedDismissalDate, person1);
		employeeDismissed = new Employee(null, validHireDate, validDismissalDate, person2);
		currentEmployee = new Employee(null, validHireDate, null , person2);
		excludedEmployee = repository.save(excludedEmployee);
		employeeDismissed = repository.save(employeeDismissed);
		currentEmployee = repository.save(currentEmployee);
	}
	
	@Test
	public void findAllNotExcludedEmployeesShouldNotRetrieveExcludedEmployees() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<EmployeeDTO> employees = repository.findAllNotExcludedEmployees(pageable);
		
		Assertions.assertTrue(employees.getContent().stream()
				.noneMatch(e -> e.getId().equals(excludedEmployee.getId())));
	}
	
	@Test
	public void findAllNotExcludedEmployeesShouldRetrieveCurrentEmployees() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<EmployeeDTO> employees = repository.findAllNotExcludedEmployees(pageable);
		
		Assertions.assertTrue(employees.getContent().stream()
				.anyMatch(e -> e.getId().equals(currentEmployee.getId())));
	}
	
	@Test
	public void findAllNotExcludedEmployeesShouldRetrieveDismissedEmployees() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<EmployeeDTO> employees = repository.findAllNotExcludedEmployees(pageable);
		
		Assertions.assertTrue(employees.getContent().stream()
				.anyMatch(e -> e.getId().equals(employeeDismissed.getId())));
	}
}
