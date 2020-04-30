
package com.songbl.safemsg.app.controller;


import com.songbl.safemsg.app.entity.UserEntity;
import com.songbl.safemsg.app.form.RegisterForm;
import com.songbl.safemsg.app.service.UserService;
import com.songbl.safemsg.common.utils.R;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 注册
 *
 * 791243928@qq.com
 */
@RestController
@RequestMapping("/app")
public class AppRegisterController {
    @Autowired(required = false)
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验

        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getUsername());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setGender(form.getGender());
        user.setPriKey(form.getPriKey());
        user.setPubKey(form.getPubKey());

        boolean b = userService.save(user);
        Map<String, Object> map = new HashMap<>();
        map.put("result",true);
        System.out.println("注册结果"+b);

        /**
         * {
         *     "msg": "success",
         *     "result": true,
         *     "code": 0
         * }
         */
        return R.ok(map);
    }
}
