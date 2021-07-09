package com.example.testesenior.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.testesenior.dto.EmployeeDTO;
import com.example.testesenior.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository repository;
	
	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAll(Pageable pageable){
		Page<EmployeeDTO> employees = repository.findAllNotExcludedEmployees(pageable);
		return employees;
	}; 
}
