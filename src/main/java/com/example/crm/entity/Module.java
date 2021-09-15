package com.example.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 功能模块
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@TableName("module")
public class Module implements Serializable {


    /**
     * 模块编号
     */
    @TableId(value = "moduleid", type = IdType.AUTO)
    private Integer moduleid;

    /**
     * 模块的说明
     */
    private String modulename;

    /**
     * 上级模块的编号
     */
    private Integer top;

    /**
     * 模块对应的请求地址
     */
    private String url;

    /**
     * 是否启用
     */
    private Integer enable;


    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Module{" +
        "moduleid=" + moduleid +
        ", modulename=" + modulename +
        ", top=" + top +
        ", url=" + url +
        ", enable=" + enable +
        "}";
    }
}
