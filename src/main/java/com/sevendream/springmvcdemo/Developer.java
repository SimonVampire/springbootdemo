package com.sevendream.springmvcdemo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Data
public class Developer implements Serializable {
    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
}
