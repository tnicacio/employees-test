package com.example.testesenior.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.testesenior.entities.Employee;
import com.example.testesenior.entities.Person;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime hireDate;
    private LocalDateTime dismissalDate;
	private Person person;
	
	public EmployeeDTO() {}

	public EmployeeDTO(Long id, LocalDateTime hireDate, LocalDateTime dismissalDate, Person person) {
		this.id = id;
		this.hireDate = hireDate;
		this.dismissalDate = dismissalDate;
		this.person = person;
	}
	
	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		hireDate = entity.getHireDate();
		dismissalDate = entity.getDismissalDate();
		person = entity.getPerson();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDateTime hireDate) {
		this.hireDate = hireDate;
	}

	public LocalDateTime getDismissalDate() {
		return dismissalDate;
	}

	public void setDismissalDate(LocalDateTime dismissalDate) {
		this.dismissalDate = dismissalDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
