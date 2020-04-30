package com.songbl.safemsg.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songbl.safemsg.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenDao extends BaseMapper<UserEntity> {
}
