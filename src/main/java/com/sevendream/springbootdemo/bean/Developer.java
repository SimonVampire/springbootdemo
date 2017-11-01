package com.sevendream.springbootdemo.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.io.Serializable;
@Entity
@Data
public class Developer implements Serializable {
    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private String sex;
    @Min(value = 18,message = "未成年啊")
    private Integer age;
}
