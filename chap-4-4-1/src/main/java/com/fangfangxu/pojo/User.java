package com.fangfangxu.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
public class User implements Serializable {
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
