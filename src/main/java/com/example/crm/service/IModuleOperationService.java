package com.example.crm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.crm.entity.ModuleOperation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
public interface IModuleOperationService extends IService<ModuleOperation> {

    List<ModuleOperation> redisListByIds(Collection<? extends Serializable> idList);
}
