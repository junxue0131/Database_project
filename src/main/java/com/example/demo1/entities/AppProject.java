package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName AppProject
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/25 23:10
 * @Version 1.0
 **/
@TableName("appProject")
public class AppProject {
    @TableField("projectId")
    private int projectid;

    @TableField("staffId")
    private int staffid;

    @TableField("submitTime")
    @DateTimeFormat(pattern="hh:mm:ss")
    private Date submittime;

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

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }
}
