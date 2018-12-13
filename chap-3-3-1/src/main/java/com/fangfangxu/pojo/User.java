package com.fangfangxu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, length = 5)
    private String name;
    @Column(nullable = false)
    private Integer age;
    public User(String name,Integer age){
        this.name=name;
        this.age=age;
    }
}
