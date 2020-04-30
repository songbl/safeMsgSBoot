

package com.songbl.safemsg.app.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.songbl.safemsg.app.entity.UserEntity;
import com.songbl.safemsg.app.form.LoginForm;

/**
 * 用户
 *   通用 Service CRUD 封装IService接口，进一步封装 CRUD 采用 get 查询单行 remove 删除 list 查询集合 page 分页
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	UserEntity login(LoginForm form);

}
