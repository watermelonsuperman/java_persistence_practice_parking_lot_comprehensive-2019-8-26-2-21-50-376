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
	
	@Select("select * from employee OFFSET #{skipCounts} ROWS FETCH NEXT #{pageSize} ROWS ONLY")
	List<Employee> selectALLByPages(@Param("skipCounts") int skipCounts,@Param("pageSize") int pageSize);
	
	@Insert("insert into employee values(#{employee.id},#{employee.name},#{employee.age})")
    void insert(@Param("employee") Employee employee);
}
