package com.example.crm.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.crm.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.crm.vo.EmpVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
public interface EmpMapper extends BaseMapper<Emp> {
    EmpVo selectOneEmpVo(@Param("logname") String logname,@Param("pwd") String password);

    List<EmpVo> selectAllEmpVo(@Param("pageStart")Integer pageStart, @Param("pageEnd")Integer pageEnd);

    IPage<EmpVo> selectAllEmpVoPage(IPage<EmpVo> page,@Param(Constants.WRAPPER) QueryWrapper<EmpVo> queryWrapper);
}
