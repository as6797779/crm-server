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
@TableName("dept")
public class Dept implements Serializable {


    /**
     * 部门编号
     */
    @TableId(value = "deptid", type = IdType.AUTO)
    private Integer deptid;

    /**
     * 部门名称
     */
    private String deptname;

    /**
     * 是否启用
     */
    private Integer enable;

    /**
     * 上级部门编号，如果自己就是顶级这里就没有数据
     */
    private Integer superior;

    /**
     * 是否为顶级部门（0：不是，1：是）
     */
    private Integer top;


    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getSuperior() {
        return superior;
    }

    public void setSuperior(Integer superior) {
        this.superior = superior;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "Dept{" +
        "deptid=" + deptid +
        ", deptname=" + deptname +
        ", enable=" + enable +
        ", superior=" + superior +
        ", top=" + top +
        "}";
    }
}
