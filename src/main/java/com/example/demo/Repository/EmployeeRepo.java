package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Employee.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {

	Employee findByEmail(String email);

	boolean existsByEmail(String email);

	boolean existsByPhoneno(Long phoneno);

	boolean existsByEmailAndIdIsNot(String email, String id);

	boolean existsByPhonenoAndIdIsNot(Long phoneno, String id);

	boolean existsByUsername(String username);

	Employee findByUsername(String username);

	void deleteByUsername(String username);

	//Employee setPassword(String encodedPassword);

	

	

}
