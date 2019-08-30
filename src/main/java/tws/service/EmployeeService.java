package tws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Employee> findAll(){
		List<Employee> employees = employeeMapper.selectAll();
		
		return employees;
		
	}

	public List<Employee> findAllEmloyeesByPages(int pageSize,int pageCount){
		int skipCounts =  pageSize * (pageCount-1);
		List<Employee> employees = employeeMapper.selectALLByPages(skipCounts,pageSize);
		return employees;
		
	}
	
	
	public void insert(Employee employee){
		employeeMapper.insert(employee);
	}
}
