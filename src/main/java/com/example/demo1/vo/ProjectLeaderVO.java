package com.example.demo1.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ProjectLeaderVO {
    @TableId(type = IdType.INPUT)
    @TableField("id")
    private int id;

    private String name;
    private int leader;
    @TableField("teamSize")
    private int teamsize;

    @TableField("dateBegin")
    private String datebegin;

    @TableField("namePublication")
    private String namepublication;

    @TableField("datePublication")
    private String datepublication;

    private String schedule;

    @TableField("leaderName")
    private String leaderName;
}
