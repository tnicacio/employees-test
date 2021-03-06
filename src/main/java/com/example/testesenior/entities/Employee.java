package com.example.testesenior.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime hireDate;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime dismissalDate;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;

	public Employee() {}

	public Employee(Long id, LocalDateTime hireDate, LocalDateTime dismissalDate, Person person) {
		this.id = id;
		this.hireDate = hireDate;
		this.dismissalDate = dismissalDate;
		this.person = person;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
