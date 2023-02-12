package com.halemia.familymanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.halemia.familymanager.dao.mapper"})
public class FamilyManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyManagerApplication.class, args);
    }

}
