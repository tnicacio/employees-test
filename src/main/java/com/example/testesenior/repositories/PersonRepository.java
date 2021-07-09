package com.example.testesenior.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testesenior.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
