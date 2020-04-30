
package com.songbl.safemsg.app.controller;



import com.songbl.safemsg.app.entity.UserEntity;
import com.songbl.safemsg.app.form.LoginForm;
import com.songbl.safemsg.app.service.UserService;
import com.songbl.safemsg.app.util.JwtUtils;
import com.songbl.safemsg.common.exception.RRException;
import com.songbl.safemsg.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * APP登录授权
 *
 * 791243928@qq.com
 * 1.@RestController注解：由下面两个注解构成
 *      @Controller
 *      @ResponseBody  //自动将数据（map或者对象）转换为JSON格式
 * 2. @RequestBody ：  将请求的json转化为对象 （通过jackson）
 *
 */
@RestController
@RequestMapping("/app")
//@Api("APP登录接口")
public class AppLoginController {
    private static Logger logger = LoggerFactory.getLogger(AppLoginController.class);

    @Autowired(required = false)
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @PostMapping("login")
//    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
        System.out.println("登录原始数据 "+form.toString());
        //用户登录
        UserEntity user = userService.login(form);

        Map<String, Object> map = new HashMap<>();
        map.put("result",user);

        test();

        return R.ok(map);
    }

    /**
     * 登录
     */
    @PostMapping("getKey")
    public R getKey(@RequestBody LoginForm form){

        //用户登录
        UserEntity user = userService.queryByMobile(form.getMobile());
        if (user==null){
            throw new RRException("手机号错误");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("result",user);


        return R.ok(map);

    }





    private    void test(){
        String WholePath = "/usr/lib/1-2-file.txt";
        String resultString = null;
        try {
            Pattern regex = Pattern.compile("([^\\\\/:*?\"<>|\r\n]+$)");
            Matcher regexMatcher = regex.matcher(WholePath);
            if (regexMatcher.find()) {
                resultString = regexMatcher.group(1);
                System.out.println(resultString);
                logger.error(resultString);
            }
        } catch (PatternSyntaxException ex) {
            System.out.println("异常了");
            // Syntax error in the regular expression
        }

    }

}
