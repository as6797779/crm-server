package com.example.crm.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.crm.entity.Emp;
import com.example.crm.exception.NotFindAnyOneException;
import com.example.crm.service.IEmpService;
import com.example.crm.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@RestController
@RequestMapping("/sys/account")
public class EmpController {

    final IEmpService empService;

    @Autowired
    public EmpController(IEmpService empService) {
        this.empService = empService;
    }

    @ResponseBody
    @GetMapping("testCachePut/{id}")
    public Emp testCacheable(@PathVariable String id) {
        Emp emp = empService.redisSelectById(id);
        return emp;
    }


    @ResponseBody
    @GetMapping("testCachePut/{id}/{ename}")
    public Emp testCachePut(@PathVariable("id") Integer id, @PathVariable String ename) {
        Emp emp = empService.getById(id);
        if (emp == null) {
            throw new NotFindAnyOneException(999, "所提供的id一个都找不到啊兄dei");
        }
        emp.setEname(ename);
        Emp newEmp = empService.redisUpdate(emp);
        return newEmp;

    }

    /**
     * 分页插件测试
     */
    @ResponseBody
    @GetMapping("testPage/{page}/{size}")
    public Map<String, Object> testPage(@PathVariable Integer page, @PathVariable Integer size) {
        IPage<Emp> empIPage = new Page<Emp>(page, size);
        empIPage = empService.getBaseMapper().selectPage(empIPage, null);
        List<Emp> records = empIPage.getRecords();
        System.out.println(records);
        Map<String, Object> map = new HashMap<>(16);
        map.put("list", records);
        map.put("pages", empIPage.getPages());
        map.put("totals", empIPage.getTotal());
        return map;
    }

    @GetMapping("empVoList")
    public ResponseEntity<IPage<EmpVo>> getEmpVoList(@RequestParam Integer current, @RequestParam Integer size, HttpServletRequest request) {
        IPage<EmpVo> empVoIPage = new Page<>(current, size);
        QueryWrapper<EmpVo> queryWrapper = new QueryWrapper<>();
        String deptid = request.getParameter("deptid");
        String positionid = request.getParameter("positionid");
        String empstatus = request.getParameter("empstatus");
        if (!StringUtils.isEmpty(deptid)) {
            queryWrapper.eq("dept.deptid", deptid);
        }
        if (!StringUtils.isEmpty(positionid)) {
            queryWrapper.eq("position.positionid", positionid);
        }
        if (!StringUtils.isEmpty(empstatus)) {
            queryWrapper.eq("empstatus", empstatus);
        }
        empService.getEmpList(empVoIPage,queryWrapper);
        return new ResponseEntity<IPage<EmpVo>>(empVoIPage, HttpStatus.OK);
    }

}

