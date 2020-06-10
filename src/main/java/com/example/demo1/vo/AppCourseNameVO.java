package com.example.demo1.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class AppCourseNameVO implements Serializable {
    @TableField("courseId")
    private int courseid;

    @TableField("staffId")
    private int staffid;

    @TableField("submitTime")
    private String submittime;

    private String staffName;

    private String courseName;

}
