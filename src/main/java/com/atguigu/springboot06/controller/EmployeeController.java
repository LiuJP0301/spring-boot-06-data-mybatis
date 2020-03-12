package com.atguigu.springboot06.controller;

import com.atguigu.springboot06.Sercvice.EmployeeService;
import com.atguigu.springboot06.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname EmployeeController
 * @Description TODO
 * @Date 2019/10/15 0015 20:19
 * @Created by Administrator - liujinpeng
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return employee;
    }

    @GetMapping("/deleEmp")
    public String deleteEmp(Integer id){
        employeeService.deleEmp(id);
        return "success";
    }
}
