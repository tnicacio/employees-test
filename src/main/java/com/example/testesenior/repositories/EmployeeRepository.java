package com.example.testesenior.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.testesenior.dto.EmployeeDTO;
import com.example.testesenior.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	 
	@Query("select new com.example.testesenior.dto.EmployeeDTO(e.id, e.hireDate, e.dismissalDate, e.person) "
			+ "from Employee e "
			+ "where (e.dismissalDate >= e.hireDate or e.dismissalDate is null)")
	Page<EmployeeDTO> findAllNotExcludedEmployees(Pageable pageable);
}
