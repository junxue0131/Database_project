package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @DateTimeFormat(pattern="hh:mm:ss")
    private Date submittime;

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

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }
}

