package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("appProject")
public class AppProject {
    @TableField("projectId")
    private int projectid;

    @TableField("staffId")
    private int staffid;

    @TableField("submitTime")
    private String submittime;

    private boolean agreement;

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int id) {
        this.projectid = id;
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

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }
}
