package com.mty.organ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

//配置springboot的包扫描
@SpringBootApplication
@MapperScan("com.mty.organ.mapper")
public class Application {

    /**
     * 启动方法
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
