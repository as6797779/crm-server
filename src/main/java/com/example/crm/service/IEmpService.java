package com.example.crm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.crm.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.crm.vo.EmpVo;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
public interface IEmpService extends IService<Emp> {

    Emp redisUpdate(Emp emp);

    Emp redisSelectById(String id);

    @Cacheable(cacheNames = "redisEmpList",unless = "#result == null")
    List<EmpVo> redisEmpVoListAll();

    EmpVo login(String logname, String password);

    void getEmpList(IPage<EmpVo> page, QueryWrapper<EmpVo> queryWrapper);
}
