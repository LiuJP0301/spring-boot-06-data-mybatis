package com.atguigu.springboot06.mapper;

import com.atguigu.springboot06.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


//指定这是一个操作数据库的mapper
//@Mapper
@Component
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
