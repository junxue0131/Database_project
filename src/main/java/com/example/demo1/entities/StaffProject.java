package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName StaffProject
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/28 16:20
 * @Version 1.0
 **/
@TableName("staffProject")
public class StaffProject {
    @TableField("projectId")
    private int projectid;
    @TableField("staffId")
    private int staffid;

    private String charge;

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
