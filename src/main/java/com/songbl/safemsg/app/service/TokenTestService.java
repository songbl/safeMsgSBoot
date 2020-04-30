package com.songbl.safemsg.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.songbl.safemsg.app.entity.UserEntity;
import com.songbl.safemsg.app.form.LoginForm;

public interface TokenTestService extends IService<UserEntity> {
    UserEntity queryByMobile(LoginForm form);
}
