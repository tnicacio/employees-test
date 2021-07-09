package com.example.testesenior.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testesenior.dto.EmployeeDTO;
import com.example.testesenior.services.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {
	
private EmployeeService service;
	
	@Autowired
	public EmployeeResource(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable){
		Page<EmployeeDTO> employees = service.findAll(pageable);
		return ResponseEntity.ok(employees);
	}

}
