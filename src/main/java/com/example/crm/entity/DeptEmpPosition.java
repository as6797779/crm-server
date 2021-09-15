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
@TableName("dept_emp_position")
public class DeptEmpPosition implements Serializable {


    /**
     * 雇员、部门和职位三者的数据关联id
     */
    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    /**
     * 部门的编号
     */
    private Integer deptid;

    /**
     * 雇员的编号
     */
    private Integer empid;

    /**
     * 雇员对应的职位编号
     */
    private Integer positionid;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    @Override
    public String toString() {
        return "DeptEmpPosition{" +
        "sid=" + sid +
        ", deptid=" + deptid +
        ", empid=" + empid +
        ", positionid=" + positionid +
        "}";
    }
}
