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
@TableName("role_module")
public class RoleModule implements Serializable {


    /**
     * 角色和模块的关系编号
     */
    @TableId(value = "rmid", type = IdType.AUTO)
    private Integer rmid;

    /**
     * 角色的编号
     */
    private Integer roleid;

    /**
     * 模块的编号
     */
    private Integer moduleid;


    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    @Override
    public String toString() {
        return "RoleModule{" +
        "rmid=" + rmid +
        ", roleid=" + roleid +
        ", moduleid=" + moduleid +
        "}";
    }
}
