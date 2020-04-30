

package com.songbl.safemsg.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songbl.safemsg.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *编写Mapper类（UserDao或者叫UserMapper）
 *
 * 用户
 *  dao：不实现具体的方法，框架通过动态代理的方式实现
 *
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
