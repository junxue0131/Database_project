package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


import java.io.Serializable;



@Data
public class Staff implements Serializable  {
    @TableId(type = IdType.AUTO)
    private long id;

    private String name;
    private String gender;
    private int age;
    private String title;
    private String degree;
    private String university;
    private String email;
    private String department;
    private String health;
}

