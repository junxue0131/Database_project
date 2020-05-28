package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Time;

/**
 * @ClassName AppCourse
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/27 22:22
 * @Version 1.0
 **/
@TableName("appCourse")
public class AppCourse {
    @TableField("courseId")
    private int courseid;

    @TableField("staffId")
    private int staffid;

    @TableField("submitTime")
    private String submittime;

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getSubmittime() {
        return submittime;
    }

    public void setSubmittime(String submittime) {
        this.submittime = submittime;
    }
}

