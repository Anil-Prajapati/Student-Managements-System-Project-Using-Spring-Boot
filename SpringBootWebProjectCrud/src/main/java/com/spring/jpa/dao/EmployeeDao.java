package com.spring.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entitry.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	//public abstract Page<Employee> findByPagination(int pageNo, int size);


}
