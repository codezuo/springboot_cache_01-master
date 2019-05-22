package com.jgsu;

import com.jgsu.bean.Department;
import com.jgsu.bean.Employee;
import com.jgsu.mapper.DepartmentMapper;
import com.jgsu.mapper.EmployeeMapper;

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
public class SpringbootCache01ApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;   //操作k-v都是字符串的
    @Autowired
    RedisTemplate redisTemplate;             //操作k-v都是对象的

    @Autowired
    RedisTemplate<Object, Employee> emRedisTemplate;

    /*
    * Redis常见五大数据类型
    *  1.String（字符串）2.list（列表）3.set（集合）4.hash（散列）5.ZSet（有序集合）
    *   1)stringRedisTemplate.opsForValue()操作String类型数据
    *   2)stringRedisTemplate.opsForHash()操作hash类型数据
    *   3)stringRedisTemplate.opsForList()操作list类型数据
    *   4)stringRedisTemplate.opsForSet()操作set类型数据
    *   5)stringRedisTemplate.opsForZSet()操作ZSet类型数据
    * */
    @Test
    public void test_Redis(){
        Employee empById = employeeMapper.getEmpByLastName("李四");
        //向redis中保存数据
       //stringRedisTemplate.opsForValue().append("aaa","lisen");
        //从redis中查找key值对应的数据
        //String msg = stringRedisTemplate.opsForValue().get("msg");
        //System.out.println(msg);

        emRedisTemplate.opsForValue().set("emp_01", empById);


    }


    @Test
    public void contextLoads() {
        Employee empById = employeeMapper.getEmpById(1);
        System.out.println(empById);
    }

    @Test
    public void selectDep(){
        Department depById = departmentMapper.getDepById(1);
        System.out.println(depById);
    }

}
