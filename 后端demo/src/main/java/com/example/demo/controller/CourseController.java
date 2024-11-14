package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @GetMapping("/page")
    public Result page(Integer pageIndex, Integer pageSize, String name, String number, String type) {
        // 创建分页对象
        Page<Course> page = new Page<>(pageIndex, pageSize);
        // 创建查询条件构造器
        LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<>();
        // 如果用户输入了name，则进行模糊查询
        if (name != null && !name.trim().isEmpty()) {
            queryWrapper.like(Course::getName, name);
        }
        // 如果用户输入了number，则进行精准查询
        if (number != null && !number.trim().isEmpty()) {
            queryWrapper.eq(Course::getNumber, number);
        }
        // 如果用户输入了type，则进行精准查询
        if (type != null && !type.trim().isEmpty()) {
            queryWrapper.eq(Course::getType, type);
        }
        // 执行分页查询
        IPage<Course> result = courseService.page(page, queryWrapper);
        // 返回结果
        return Result.suc(result.getRecords(), result.getTotal());
    }

}









