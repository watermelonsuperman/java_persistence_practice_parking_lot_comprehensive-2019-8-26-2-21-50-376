package tws.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
	EmployeeMapper employeeMapper;
//    @GetMapping("/")
//    public ResponseEntity<List<Employee>> getAll() {
//        return ResponseEntity.ok(employeeService.findAll());
//    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmloyeesByPages(@Param(value = "pageSize") Integer pageSize,@Param(value = "pageCount")Integer pageCount) {
        if(pageSize == null || pageCount == null){
        	return ResponseEntity.ok(employeeService.findAll());
        }
    	return ResponseEntity.ok(employeeService.findAllEmloyeesByPages(pageSize,pageCount));
    }

    @PostMapping("")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
    	employeeService.insert(employee);
        return ResponseEntity.created(URI.create("/employees/" + employee.getId())).body(employee);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable int id,@RequestBody Employee employee){
    	employeeService.update(id,employee);
    }
}
