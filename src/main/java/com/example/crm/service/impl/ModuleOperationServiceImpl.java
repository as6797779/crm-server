package com.example.crm.service.impl;

import com.example.crm.entity.ModuleOperation;
import com.example.crm.mapper.ModuleOperationMapper;
import com.example.crm.service.IModuleOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@Service
public class ModuleOperationServiceImpl extends ServiceImpl<ModuleOperationMapper, ModuleOperation> implements IModuleOperationService {

    @Override
    @Cacheable(cacheNames = "ListByIds",key = "#idList", unless = "#result == null")
    public List<ModuleOperation> redisListByIds(Collection<? extends Serializable> idList) {
        return listByIds(idList);
    }
}
