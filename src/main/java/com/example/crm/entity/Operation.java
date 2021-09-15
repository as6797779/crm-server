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
@TableName("operation")
public class Operation implements Serializable {


    /**
     * 功能编号
     */
    @TableId(value = "operationid", type = IdType.AUTO)
    private Integer operationid;

    /**
     * 功能名称
     */
    private String oname;

    /**
     * 功能说明
     */
    private String description;


    public Integer getOperationid() {
        return operationid;
    }

    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Operation{" +
        "operationid=" + operationid +
        ", oname=" + oname +
        ", description=" + description +
        "}";
    }
}
