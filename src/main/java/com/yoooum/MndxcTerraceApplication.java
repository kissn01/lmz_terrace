package com.yoooum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com/yoooum/dao")
@SpringBootApplication
public class MndxcTerraceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MndxcTerraceApplication.class, args);
    }

}
