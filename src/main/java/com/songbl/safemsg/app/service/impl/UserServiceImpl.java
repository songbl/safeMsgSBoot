

package com.songbl.safemsg.app.service.impl;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songbl.safemsg.app.dao.UserDao;
import com.songbl.safemsg.app.entity.UserEntity;
import com.songbl.safemsg.app.form.LoginForm;
import com.songbl.safemsg.app.service.UserService;
import com.songbl.safemsg.common.exception.RRException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  MVC:
 *   C:控制层调用 Service（业务层） ，service调用dao（持久层-由于mybatis不再写具体实现，直接使用）。
 *
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Autowired
	UserService userService ;

	@Override
	public UserEntity queryByMobile(String mobile) {

		//我认为通过service 调用的，但是感觉不到啥优势
//		userService.getOne()

		return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
	}

	@Override
	public UserEntity login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
//		System.out.println("查询的user是"+user.toString());
//		Assert.notNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("手机号或密码错误");
		}

		return user;
	}
}
