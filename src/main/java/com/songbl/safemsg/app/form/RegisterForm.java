
package com.songbl.safemsg.app.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 注册表单
 *
 * 791243928@qq.com
 *
 *
 */
@Data
public class RegisterForm {


    private String username;

    @NotBlank(message="手机号不能为空")
    private String mobile;


    @NotBlank(message="密码不能为空")
    private String password;

    private int gender ;

    private String priKey ;

    private String pubKey ;


}
