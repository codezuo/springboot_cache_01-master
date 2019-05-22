package com.jgsu.mapper;

import com.jgsu.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")  //查找
    public Department getDepById(Integer id);

    @Delete("delete from department where id = #{id}")   //删除
    public void deleteDep(Integer id);

    @Insert("insert into department(departmentName) values(#{departmentName})")
    public void insertDep(Department department);        //插入

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public void updateDep(Department department);         //更新
}
