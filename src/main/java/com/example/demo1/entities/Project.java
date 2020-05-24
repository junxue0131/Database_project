package com.example.demo1.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName Project
 * @Description TODO
 * @Author Xue
 * @Date 2020/5/24 19:43
 * @Version 1.0
 **/
public class Project {
    @TableId(type = IdType.INPUT)
    @TableField("id")
    private int id;

    private String name;
    private int leader;
    @TableField("teamSize")
    private int teamsize;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date datebegin;

    @TableField("namePublication")
    private String namepublication;

    @TableField("datePublication")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date datepublication;

    private String schedule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }

    public int getTeamsize() {
        return teamsize;
    }

    public void setTeamsize(int teamsize) {
        this.teamsize = teamsize;
    }

    public Date getDatebegin() {
        return datebegin;
    }

    public void setDatebegin(Date datebegin) {
        this.datebegin = datebegin;
    }

    public String getNamepublication() {
        return namepublication;
    }

    public void setNamepublication(String namepublication) {
        this.namepublication = namepublication;
    }

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
