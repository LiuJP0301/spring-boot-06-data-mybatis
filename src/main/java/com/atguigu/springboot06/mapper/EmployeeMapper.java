package com.atguigu.springboot06.mapper;

import com.atguigu.springboot06.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

//@Mapper
@Component
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee set lastName=#{lastName}, email=#{email},gender=#{gender},d_id=#{dId} where id = #{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    public void deleEmpById(Integer id);

    @Insert("INSERT INTO employee(lastName, email, gender, d_id) VALUES(#{lastName}, #{email}, #{gender}, #{dId})")
    public void insertEmp(Employee employee);
}
