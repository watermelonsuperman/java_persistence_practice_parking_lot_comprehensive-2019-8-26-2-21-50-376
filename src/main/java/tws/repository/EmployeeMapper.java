package tws.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
	@Select("select * from employee")
   List<Employee> selectAll();
	
	@Insert("insert into employee values(#{employee.id},#{employee.name},#{employee.age})")
   void insert(@Param("employee") Employee employee);
}
