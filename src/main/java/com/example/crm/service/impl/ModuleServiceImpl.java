package com.example.crm.service.impl;

import com.example.crm.entity.Module;
import com.example.crm.mapper.ModuleMapper;
import com.example.crm.service.IModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 功能模块 服务实现类
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

    @Override
    @Cacheable(cacheNames = "listByRoleId",key = "#roleid",unless = "#result == null")
    public List<Module> listByRoleId(Integer roleid) {
        List<Module> list = getBaseMapper().selectByRoleId(roleid);
        return list;
    }
}
