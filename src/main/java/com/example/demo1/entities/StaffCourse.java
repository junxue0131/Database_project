package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;

/**
 * @ClassName StaffCourse
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/28 16:05
 * @Version 1.0
 **/
@TableName("staffCourse")
public class StaffCourse {
    @TableField("courseId")
    private int courseid;
    @TableField("staffId")
    private int staffid;
    @TableField("courseBegin")
    private Timestamp coursebegin;
    @TableField("courseEnd")
    private Timestamp courseend;

    private String grade;

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

    public Timestamp getCoursebegin() {
        return coursebegin;
    }

    public void setCoursebegin(Timestamp coursebegin) {
        this.coursebegin = coursebegin;
    }

    public Timestamp getCourseend() {
        return courseend;
    }

    public void setCourseend(Timestamp courseend) {
        this.courseend = courseend;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
