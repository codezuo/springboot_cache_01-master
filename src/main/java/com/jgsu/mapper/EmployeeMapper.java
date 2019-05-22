package com.jgsu.mapper;

import com.jgsu.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id =  #{id}")
    public Employee getEmpById(Integer id);     //根据id查询数据

    @Insert("insert into employee (lastName, email, gender, d_id) values (#{lastName},#{email},#{gender},#{d_id})  ")
    public void insertEmp(Employee employee);   //插入数据

    @Update("update employee set lastName = #{lastName},email = #{email},gender = #{gender},d_id = #{d_id} where id = #{id}")
    public void updateEmp(Employee employee);               //更新数据

    @Delete("delete from employee where id = #{id}")
    public void deleteEmpById(Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);   //通过lastName查询数据
}
