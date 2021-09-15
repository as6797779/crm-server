package com.example.crm.service.impl;

import com.example.crm.entity.Position;
import com.example.crm.mapper.PositionMapper;
import com.example.crm.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 这里的职位是一个简化的操作 服务实现类
 * </p>
 *
 * @author lonely-top
 * @since 2021-09-06
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

}
