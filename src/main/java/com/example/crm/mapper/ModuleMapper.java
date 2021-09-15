package com.example.crm.mapper;

import com.example.crm.entity.Module;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 功能模块 Mapper 接口
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
public interface ModuleMapper extends BaseMapper<Module> {

    List<Module> selectByRoleId(@Param("roleid") Integer roleid);
}
