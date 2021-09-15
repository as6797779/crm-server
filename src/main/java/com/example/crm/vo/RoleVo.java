package com.example.crm.vo;

import com.example.crm.entity.Module;
import com.example.crm.entity.Role;

import java.util.List;

public class RoleVo extends Role {

    List<Module> modules;

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
