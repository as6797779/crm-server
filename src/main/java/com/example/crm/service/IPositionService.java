package com.example.crm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.crm.entity.Position;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


/**
 * <p>
 * 这里的职位是一个简化的操作 服务类
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@Cacheable(cacheNames = "position")
public interface IPositionService extends IService<Position> {
    @Override
    @Cacheable(cacheNames = "select_positionList",key = "#queryWrapper.sqlSelect", unless = "#result == null")
    default List<Position> list(Wrapper<Position> queryWrapper) {
        return IService.super.list(queryWrapper);
    }
}

