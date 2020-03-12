package com.atguigu.springboot06;

import com.atguigu.springboot06.bean.Employee;
import com.atguigu.springboot06.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot06DataMybatisApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /*@Autowired
    RedisTemplate redisTemplate;*/

    @Resource
    RedisTemplate<Object, Employee> empRedisTemplate;


    @Test
    public void test01(){
//        Employee employee = employeeMapper.getEmpById(1);
//        empRedisTemplate.opsForValue().set("emp-01", employee);
        //stringRedisTemplate.opsForValue().append("msg", "hello");
    }

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}
