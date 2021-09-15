package com.example.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 这里的职位是一个简化的操作
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@TableName("position")
public class Position implements Serializable {


    /**
     * 职位编号
     */
    @TableId(value = "positionid", type = IdType.AUTO)
    private Integer positionid;

    /**
     * 职位的名称
     */
    private String pname;


    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Position{" +
        "positionid=" + positionid +
        ", pname=" + pname +
        "}";
    }
}
