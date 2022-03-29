package com.example.logtest;


import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;


import javax.persistence.*;


@Data
@Entity
@Table(name= "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private  String last_name;


}
