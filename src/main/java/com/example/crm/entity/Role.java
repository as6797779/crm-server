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
@TableName("role")
public class Role implements Serializable {


    /**
     * 角色编号
     */
    @TableId(value = "roleid", type = IdType.AUTO)
    private Integer roleid;

    /**
     * 角色的名称
     */
    private String rname;

    /**
     * 角色的描述
     */
    private String description;

    /**
     * 角色的状态（是否启用，1对应启用，0对应未启用）
     */
    private Integer status;


    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
        "roleid=" + roleid +
        ", rname=" + rname +
        ", description=" + description +
        ", status=" + status +
        "}";
    }
}
