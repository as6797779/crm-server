package com.example.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.crm.entity.Dept;
import com.example.crm.service.IDeptService;
import com.example.crm.service.IEmpService;
import com.example.crm.vo.EmpVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("功能测试")
@SpringBootTest
class EmpServiceImplTest {

    @Autowired
    IEmpService empService;
    @Autowired
    IDeptService deptService;

    @Test
    void login() {
        QueryWrapper<Dept> s = new QueryWrapper();
        s.select("abc","cba");
        s.eq("s","b");
        s.eq("s","c");
        System.out.println(s.getSqlSelect());
        System.out.println(s.getSqlComment());
        System.out.println(s.getSqlSegment());
        System.out.println(s.getCustomSqlSegment());
    }

    @Test
    void selectPage() {
        IPage<EmpVo> page = new Page<>(1,2);
        empService.getEmpList(page,new QueryWrapper<>());
        System.out.println(page.getRecords());
    }
}