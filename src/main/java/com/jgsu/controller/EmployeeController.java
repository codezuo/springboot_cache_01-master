package com.jgsu.controller;

import com.jgsu.bean.Employee;
import com.jgsu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/springboot_cache_01/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        Employee empById = employeeService.getEmpById(id);
        return empById;
    }

    @GetMapping("/springboot_cache_01/emp")
    public Employee updateEmp(Employee employee){
        Employee updateEmp = employeeService.updateEmp(employee);
        return updateEmp;
    }

    @GetMapping("/springboot_cache_01/deleteEmp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/springboot_cache_01/getLastName/{lastName}")   //通过lastName查询数据
    public Employee getEmpByLastName(@PathVariable("lastName ") String lastName){
        Employee empByLastName = employeeService.getEmpByLastName(lastName);
        return empByLastName;
    }

}
