package com.example.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.crm.entity.*;
import com.example.crm.entity.Module;
import com.example.crm.mapper.EmpMapper;
import com.example.crm.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.crm.service.IModuleOperationService;
import com.example.crm.service.IModuleService;
import com.example.crm.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@Service
@CacheConfig(cacheNames = "emp")
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Autowired
    IModuleService moduleService;
    @Autowired
    IModuleOperationService moduleOperationService;

    @Override
    @CachePut(cacheNames = "redisSelectById",key = "#result.empid",unless = "#result == null")
    public Emp redisUpdate(Emp emp) {
        boolean b = updateById(emp);
        if (b){
            return emp;
        }
        return null;
    }

    @Override
    @Cacheable(cacheNames = "redisSelectById",key = "#id",unless = "#result == null")
    public Emp redisSelectById(String id) {
        Emp emp = getById(id);
        return emp;
    }

    @Override
    public EmpVo login(String logname, String password) {
        EmpVo empVo = getBaseMapper().selectOneEmpVo(logname, password);
        if (empVo == null){
            return null;
        }
        List<Role> roles = empVo.getRoles();
        //为empVo创建module和moduleOperations数组
        List<Module> modules = new ArrayList<>();
        empVo.setModules(modules);
        //给M数组添加元素
        if(!CollectionUtils.isEmpty(roles)){
            for (Role role : roles) {
                Integer roleid = role.getRoleid();
                List<Module> list = moduleService.listByRoleId(roleid);
                if (list != null) {
                    modules.addAll(list);
                }
            }
        }
        if (!CollectionUtils.isEmpty(modules)){
            List<Integer> list = new ArrayList<>(16);
            for (Module module : modules) {
                list.add(module.getModuleid());
            }
            empVo.setModuleOperations(moduleOperationService.redisListByIds(list));
        }
        return empVo;
    }

    @Override
    @Cacheable(cacheNames = "redisEmpList",unless = "#result == null")
    public List<EmpVo> redisEmpVoListAll(){
        List<EmpVo> empVos = getBaseMapper().selectAllEmpVo(0, 1000);
        return empVos;
    }

    @Override
    public void getEmpList(IPage<EmpVo> page, QueryWrapper<EmpVo> queryWrapper){
        getBaseMapper().selectAllEmpVoPage(page,queryWrapper);
    }
}
