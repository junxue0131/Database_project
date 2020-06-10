package com.example.demo1.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class StaffProjectNameVo {
    @TableField("projectId")
    private int projectid;
    @TableField("staffId")
    private int staffid;

    private String charge;

    private String projectName;

    private String staffName;
}
