package com.example.crm.controller;


import com.example.crm.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    final IDeptService deptService;
    @Autowired
    public DeptController(IDeptService deptService) {
        this.deptService = deptService;
    }
}

