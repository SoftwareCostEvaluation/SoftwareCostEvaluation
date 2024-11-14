package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService extends IService<Course> {
    Page<Course> page(Page<Course> page);
}
