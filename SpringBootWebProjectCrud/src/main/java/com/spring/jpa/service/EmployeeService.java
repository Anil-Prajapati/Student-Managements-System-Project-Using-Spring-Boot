package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.dao.EmployeeDao;
import com.spring.jpa.entitry.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao empdao;
	//SAVE OF THE EMPLOYEE
	public Employee saveEmployee(Employee emp)
	{
		return empdao.save(emp);
	}
	//GET ALL OF THE EMPLOYEE
	public List<Employee> getAll()
	{
		return empdao.findAll();
	}
	//UPDATE OF  THE EMPLOYEE
	public Employee getEmployeeById(Integer id)
	{
		Optional<Employee> optional=empdao.findById(id);
		Employee employee=null;
		if(optional.isPresent())
		{
			employee=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee Id is Not found"+id);
		}
		return employee;
	}
	//DELETE OF THE EMPLOYE
	public void deleteEmployee(Integer id)
	{
		empdao.deleteById(id);
	}
	
	//THAT ARE THE CONCEPT OF THE PAGINATION DYNAMIC
//	 public Page<Employee> findByPagination(int pageNo, int size) {
//		  // TODO Auto-generated method stub
//		  Pageable pageable = PageRequest.of(pageNo-1,size);
//		  return empdao.findAll(pageable);
//		 }


}
