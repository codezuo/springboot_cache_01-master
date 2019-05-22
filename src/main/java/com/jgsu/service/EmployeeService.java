package com.jgsu.service;

import com.jgsu.bean.Employee;

import com.jgsu.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
//@CacheConfig抽取缓存的公共注解,这里指代@Cacheable和@CachePut里的value = "/springboot_cache_01/emp"
@CacheConfig(cacheNames = "/springboot_cache_01/emp")
@Service
public class EmployeeService {
    /*
    * 将方法运行的结果进行缓存，以后再要相同的数据，可以直接从缓存中获取，不用调用方法
    * cacheManager管理多个cache组件的，对缓存的真正CRUD操作在组件中，每个缓存组件都有自己唯一的一个名字
    * 几个属性:
    *       cacheNames/value:指定缓存组件的名字:
    *       key:缓存数据使用的
    * */
    @Autowired
    EmployeeMapper employeeMapper;
    //1.@Cacheable 缓存作用，在程序执行之前先检查缓存中有没有这个数据，如果没有就运行方法并将结果放入缓存
    @Cacheable
    public Employee getEmpById(Integer id){
        Employee empById = employeeMapper.getEmpById(id);
        return empById;           //将查询到的id返回出去

    }
    //2.@CachePut 既调用方法又更新缓存数据，达到同步更新的目的
    //@CachePut里面value的值为：查询的路径(既从哪里查询数据)，key="#result.id"为了达到与数据库达到缓存(因为id为主键，且根据id查到对应的数据并更新)
    @CachePut(key = "#result.id")  //value = "/springboot_cache_01/emp"
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /*3.@CacheEvict缓存清除
    *   a.) key="#id"：指定要清除的数据
    *   b.) allEntries = true: 指定清除缓存中的所有数据
    *   c.) beforeInvocation = false(默认):是否在方法执行之前清除缓存（默认方法执行后清除）
    * */
    @CacheEvict(key = "#id") //value = "/springboot_cache_01/emp"
    public void deleteEmp(Integer id){
        employeeMapper.deleteEmpById(id);
    }

    /*
    * 4.@Caching：定义度咋的缓存规则，它是@CacheEvict,@CachePut和@Cacheable的结合
    * */
    @Caching(
            cacheable = {
                    @Cacheable(key = "#lastName")    //通过lsatName缓存中的数据，括号里可以添加value = "/springboot_cache_01/emp"
            },
            put = {
                    @CachePut(key = "#result.id"),  //通过id查询缓存中的数据
                    @CachePut(key = "#result.email")  //通过email查询缓存中的数据
            }
    )
    public Employee getEmpByLastName(String lastName){
        Employee empByLastName = employeeMapper.getEmpByLastName(lastName);
        return empByLastName;
    }

}
