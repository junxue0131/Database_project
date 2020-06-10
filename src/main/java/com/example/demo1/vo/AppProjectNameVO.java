package com.example.demo1.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class AppProjectNameVO {
    @TableField("projectId")
    private int projectid;

    @TableField("staffId")
    private int staffid;

    @TableField("submitTime")
    private String submittime;

    private boolean agreement;

    private String staffName;

    private String projectName;
}
