package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName Course
 * @Description 课程表数据库表实体类
 * @Author Xue
 * @Date 2020/5/24 18:35
 * @Version 1.0
 **/
public class Course {
    @TableId(type = IdType.INPUT)
    @TableField("id")
    private int id;

    private String name;
    private int classhour;
    private double credit;
    @TableField("maxCourseNumber")
    private int maxcoursenumber;
    @TableField("courseNumber")
    private int coursenumber;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClasshour() {
        return classhour;
    }

    public void setClasshour(int classhour) {
        this.classhour = classhour;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getMaxCourseNumber() {
        return maxcoursenumber;
    }

    public void setMaxCourseNumber(int maxcoursenumber) {
        this.maxcoursenumber = maxcoursenumber;
    }

    public int getCourseNumber() {
        return coursenumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.coursenumber = courseNumber;
    }
}
