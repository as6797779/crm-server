package com.example.crm.vo;

import com.example.crm.entity.*;
import com.example.crm.entity.Module;

import java.util.List;

public class EmpVo extends Emp {

    Dept dept;
    Position position;
    List<Role> roles;
    List<Module> modules;
    List<ModuleOperation> moduleOperations;

    public List<ModuleOperation> getModuleOperations() {
        return moduleOperations;
    }

    public void setModuleOperations(List<ModuleOperation> moduleOperations) {
        this.moduleOperations = moduleOperations;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
