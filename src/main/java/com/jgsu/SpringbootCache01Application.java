package com.jgsu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 一》搭建基本环境
* 1.导入数据库文件 创建出表
* 2.创建javabean封装数据
* 3.整合mybatis操作数据库
*    (1)配置数据源信息
*    (2)使用注解版的mybatis
*       a.@MapperScan注解指定需要扫描的mapper接口所在的包
* 二》快速体验缓存
*    1.开启基于注解的缓存
*    2.标注缓存注解即可
* 开发中使用缓存中间件如：redis,memcached,ehcache
* 三》整合redis作为缓存
*    1.安装redis：使用docker
*    2.引入redis的spring-boot-start-data-redis依赖
*    3.配置redis：spring.redis.host=192.168.198.132
* */
@MapperScan(value = "com.jgsu.mapper")  //@MapperScan注解指定需要扫描的mapper接口所在的包
@SpringBootApplication
public class SpringbootCache01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCache01Application.class, args);
    }

}
