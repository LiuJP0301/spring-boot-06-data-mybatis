package com.atguigu.springboot06.Sercvice;

import com.atguigu.springboot06.bean.Employee;
import com.atguigu.springboot06.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Classname EmployeeService
 * @Description TODO
 * @Date 2019/10/15 0015 20:14
 * @Created by Administrator - liujinpeng
 */
@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable()
    public Employee getEmp(Integer id){
        System.out.println("查询" + id + "号员工");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;

    }

    /**
     * @CachePut 既调用方法，也更新缓存
     */
    @CachePut(key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp");
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清楚
     *
     */
    @CacheEvict(key = "#id")
    public void deleEmp(Integer id){
        System.out.println("deleEmp:" + id);
    }
}
