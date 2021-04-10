package com.luv2code.springboot.cruddemo.repository;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
//	public List<Employee> findAll();
//	no need to write any more code.

//
////	add full crud support in the Repository
//	public Employee findById(int id);
//
//	public void save(Employee emp);
//
//	public void deleteById(int id);
}

