package com.songbl.safemsg.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songbl.safemsg.app.dao.UserDao;
import com.songbl.safemsg.app.entity.UserEntity;
import com.songbl.safemsg.app.form.LoginForm;
import com.songbl.safemsg.app.service.TokenTestService;
import org.springframework.stereotype.Service;



@Service
public class TokenRestServiceImpl extends ServiceImpl<UserDao, UserEntity> implements TokenTestService {


    @Override
    public UserEntity queryByMobile(LoginForm form) {
        System.out.println("token测试"+form.toString());
        return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", form.getMobile()));

    }
}
