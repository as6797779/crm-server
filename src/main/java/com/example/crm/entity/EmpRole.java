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
@TableName("emp_role")
public class EmpRole implements Serializable {


    /**
     *  雇员与角色的关系编号
     */
    @TableId(value = "erid", type = IdType.AUTO)
    private Integer erid;

    /**
     * 雇员编号
     */
    private Integer empid;

    /**
     * 角色的编号
     */
    private Integer roleid;


    public Integer getErid() {
        return erid;
    }

    public void setErid(Integer erid) {
        this.erid = erid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "EmpRole{" +
        "erid=" + erid +
        ", empid=" + empid +
        ", roleid=" + roleid +
        "}";
    }
}
