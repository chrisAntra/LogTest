package com.example.logtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication

public class LogTestApplication {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {

        SpringApplication.run(LogTestApplication.class, args);
    }
    @PostConstruct
    private void initDb() {
        String sqlStatements[] = {
                "drop table employees if exists",
                "create table employees(id serial,first_name varchar(255),last_name varchar(255))",
                "insert into employees(first_name, last_name) values('Eugen','Paraschiv')",
                "insert into employees(first_name, last_name) values('Scott','Tiger')"
        };

        Arrays.asList(sqlStatements).forEach(sql -> {
            jdbcTemplate.execute(sql);
        });

        // Query test data and print results
    }

}
