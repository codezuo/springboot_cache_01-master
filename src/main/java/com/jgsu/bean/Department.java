package com.jgsu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //set方法，get方法，tostring方法@EqualsAndHashCode方法
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //有参构造
public class Department {
    private Integer id;
    private String departmentName;

}
