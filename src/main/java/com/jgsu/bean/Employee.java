package com.jgsu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data               //set方法，get方法，tostring方法@EqualsAndHashCode方法
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //有参构造
public class Employee implements Serializable {  //实现序列化
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer d_id;

}
