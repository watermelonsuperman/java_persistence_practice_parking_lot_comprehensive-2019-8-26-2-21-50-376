package tws.apitest;

import org.hamcrest.CoreMatchers;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tws.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

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
	public void should_return_all_employees() throws Exception {
		// given
		jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(1,'zhangsan', 21);");
		Employee employee = new Employee(1, "zhangsan", 21);
		List<Employee> employees = new ArrayList();
		employees.add(employee);

		//String result = objectMapper.writeValueAsString(employees);
		this.mockMvc.perform(get("/employees"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id", CoreMatchers.is(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name", CoreMatchers.is("zhangsan")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].age", CoreMatchers.is(21)));
	}
	
	public void should_return_employee_when_employeeController_insert_given_employee() throws Exception{
		Employee employee = new Employee(1, "zhangsan", 21);
		List<Employee> employees = new ArrayList();
		employees.add(employee);
    	String postString = objectMapper.writeValueAsString(employees);

		this.mockMvc.perform(
    			MockMvcRequestBuilders
    			.post("/users")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(postString)
    			)
    			.andDo(print())
    			.andExpect(status().isCreated())
    			.andExpect(
                		MockMvcResultMatchers.jsonPath("$", CoreMatchers.is(postString))
    					);

	}
	
	
	
	
	

//	public static void main(String[] args) throws JsonProcessingException {
//		ObjectMapper om = new ObjectMapper();
//		Employee employee = new Employee(1, "zhangsan", 21);
//		List<Employee> employees = new ArrayList();
//		employees.add(employee);
//		String result = om.writeValueAsString(employees);
//		System.out.print(result);
//	}

}
