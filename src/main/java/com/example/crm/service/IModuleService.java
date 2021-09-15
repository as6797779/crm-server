package com.example.crm.service;

import com.example.crm.entity.Module;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 功能模块 服务类
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
public interface IModuleService extends IService<Module> {

    List<Module> listByRoleId(Integer roleid);
}
