package com.example.demo1.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

@Data
public class StaffCourseNameVO {
    @TableField("courseId")
    private int courseid;
    @TableField("staffId")
    private int staffid;
    @TableField("courseBegin")
    private Timestamp coursebegin;
    @TableField("courseEnd")
    private Timestamp courseend;

    private String grade;

    @TableField("courseName")
    private String courseName;

    @TableField("staffName")
    private String staffName;
}
