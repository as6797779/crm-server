package com.example.crm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.crm.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
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
@Cacheable(cacheNames = "dept")
public interface IDeptService extends IService<Dept> {

    @Override
    @Cacheable(cacheNames = "select_deptList",key = "#queryWrapper.sqlSelect", unless = "#result == null")
    default List<Dept> list(Wrapper<Dept> queryWrapper) {
        return IService.super.list(queryWrapper);
    }
}
