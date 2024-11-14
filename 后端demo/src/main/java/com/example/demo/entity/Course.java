package com.example.demo.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class Course {
    @TableId
    private int id;
    private String name;
    private String introduction;
    private String cover;
    private String video;
    private String author;
    private String number;
    private String type;
}
