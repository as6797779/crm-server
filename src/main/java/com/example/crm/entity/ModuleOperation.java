package com.example.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@TableName("module_operation")
public class ModuleOperation implements Serializable {


    /**
     * 模块与操作的关系编号
     */
    @TableId(value = "moid", type = IdType.AUTO)
    private Integer moid;

    /**
     * 模块的编号
     */
    private Integer moduleid;

    /**
     * 功能编号
     */
    private Integer operationid;

    /**
     * 组件所在路径
     */
    private String cpath;

    /**
     * 组件名称
     */
    private String component;

    /**
     * 可用权限名称
     */
    private String rule;

    /**
     * 组件对应的请求路径
     */
    private String path;

    /**
     * 是否启用为菜单
     */
    private Integer enable;


    public Integer getMoid() {
        return moid;
    }

    public void setMoid(Integer moid) {
        this.moid = moid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public Integer getOperationid() {
        return operationid;
    }

    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
    }

    public String getCpath() {
        return cpath;
    }

    public void setCpath(String cpath) {
        this.cpath = cpath;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "ModuleOperation{" +
        "moid=" + moid +
        ", moduleid=" + moduleid +
        ", operationid=" + operationid +
        ", cpath=" + cpath +
        ", component=" + component +
        ", rule=" + rule +
        ", path=" + path +
        ", enable=" + enable +
        "}";
    }
}
