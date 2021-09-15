package com.example.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.crm.entity.Dept;
import com.example.crm.entity.Position;
import com.example.crm.service.IDeptService;
import com.example.crm.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SelectController {
    final IDeptService deptService;
    final IPositionService positionService;
    @Autowired
    public SelectController(IDeptService deptService, IPositionService positionService) {
        this.deptService = deptService;
        this.positionService = positionService;
    }

    @GetMapping("/select/dept/list")
    public ResponseEntity<List<Dept>> getDeptList(){
        List<Dept> depts = deptService.list(new QueryWrapper<>(new Dept(),"deptid", "deptname"));
        return new ResponseEntity<>(depts,HttpStatus.OK);
    }

    @GetMapping("/select/position/list")
    public ResponseEntity<List<Position>> getPositionList(){
        List<Position> positions = positionService.getBaseMapper().selectList(new QueryWrapper<>(new Position(),"positionid", "pname"));
        return new ResponseEntity<>(positions,HttpStatus.OK);
    }
}
