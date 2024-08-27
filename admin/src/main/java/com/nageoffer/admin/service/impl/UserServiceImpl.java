package com.nageoffer.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.admin.common.convention.exception.ServiceException;
import com.nageoffer.admin.common.enums.UserErrorCodeEnum;
import com.nageoffer.admin.dao.entity.UserDO;
import com.nageoffer.admin.dao.mapper.UserMapper;
import com.nageoffer.admin.dto.resp.UserRespDTO;
import com.nageoffer.admin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    @Override
    public UserRespDTO getUserByUsername(String username){
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getUsername,username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        UserRespDTO result = new UserRespDTO();
        if(userDO == null)
        {
            throw new ServiceException(UserErrorCodeEnum.USER_NULL);
        }
        org.springframework.beans.BeanUtils.copyProperties(userDO,result);
        return result;
    }
}