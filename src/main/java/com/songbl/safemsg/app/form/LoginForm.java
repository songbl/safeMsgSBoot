

package com.songbl.safemsg.app.form;

import lombok.Data;

/**
 * 登录表单
 *
 * 791243928@qq.com
 */
@Data
//@ApiModel(value = "登录表单")
public class LoginForm {
//    @ApiModelProperty(value = "手机号")
//    @NotBlank(message="手机号不能为空")
    private String mobile;

//    @ApiModelProperty(value = "密码")
//    @NotBlank(message="密码不能为空")
    private String password;

}
