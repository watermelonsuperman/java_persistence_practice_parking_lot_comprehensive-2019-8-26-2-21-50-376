package tws.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.Employee;
import tws.service.EmployeeService;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;


    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "employee");
    }

    @Test
    public void shouldFetchAllEmployees() {
        // given
        jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(1,'zhangsan', 21);");
        // when
        List<Employee> employees = employeeMapper.selectAll();
        // then
        assertEquals(1, employees.size());
        assertEquals(1, employees.get(0).getId());
        assertEquals("zhangsan", employees.get(0).getName());
        assertEquals(21, employees.get(0).getAge());

    }
    
    
    @Test
    public void should_fatch_part_employees_when_findAllEmloyeesByPages_given_page_and_size(){
    	//given
        jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(1,'zhangsan', 21);");
        int page = 1;
        int pageSize = 1;
        int skipCounts = page * (pageSize-1);
    	//when
        List<Employee> employees = employeeMapper.selectALLByPages(skipCounts,pageSize);
    	//then
        assertEquals(1, employees.get(0).getId());
        assertEquals("zhangsan", employees.get(0).getName());
        assertEquals(21, employees.get(0).getAge());
    }
    
    @Test
    public void should_return_correct_when_insert_given_employee(){
    	//given
    	Employee employee = new Employee(1,"wyx",21);
    	
    	//when
    	employeeMapper.insert(employee);
    	List<Employee> employees = employeeMapper.selectAll();

    	//then
    	assertEquals(1, employees.size());
        assertEquals(1, employees.get(0).getId());
        assertEquals("wyx", employees.get(0).getName());
        assertEquals(21, employees.get(0).getAge());

    	
    }
    @Test
    public void should_update_employee_when_update_given_employee_and_id(){
    	//given
        jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(1,'zhangsan', 21);");

    	Employee employee = new Employee(1,"wyx",21);
    	int id =1;
    	
    	//when
    	employeeMapper.update(1,employee);
    	List<Employee> employees = employeeMapper.selectAll();

    	//then
    	assertEquals(1, employees.size());
        assertEquals(1, employees.get(0).getId());
        assertEquals("wyx", employees.get(0).getName());
        assertEquals(21, employees.get(0).getAge());

    }
    @Test
    public void should_delete_employee_when_delete_given_id(){
    	//given
        jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(1,'zhangsan', 21);");

    	int id =1;
    	
    	//when
    	employeeMapper.delete(1);
    	List<Employee> employees = employeeMapper.selectAll();

    	//then
    	assertEquals(0, employees.size());
   
    }
    
}
