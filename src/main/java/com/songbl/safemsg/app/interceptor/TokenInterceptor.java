

package com.songbl.safemsg.app.interceptor;


import com.songbl.safemsg.app.annotation.Login;
import com.songbl.safemsg.app.util.JwtUtils;
import com.songbl.safemsg.common.exception.RRException;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Interceptor：
 *    主要作用：拦截用户请求，进行处理，比如用户登录情况，权限验证
 *  该类作用：
 *          用于控制App端的token，即登录状态。如果用户的token过期或者没有，就返回异常
 *
 * 权限(Token)验证
 *    1.WebMvcConfig 中添加了这个拦截器 (过滤的时候，app才用这个)
 *
 * 过滤 /app下的所有请求
 *
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtils jwtUtils;

    public static final String USER_KEY = "userId";

    //SpringMVC会将请求通过处理器映射器将请求交给匹配的Handler处理，
    // 这个handler参数就是描述的处理请求的Handler
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TokenInterceptor");
        Login annotation;
        // 如果是springmvc请求(Controller)
        if(handler instanceof HandlerMethod) {
            // 返回标注在方法上的指定类型的注解；
            // 如果方法上没有标记Login这个注解，返回null，不做拦截
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
            System.out.println( "是mvc请求");
        }else{
            return true;
        }

        if(annotation == null){
            System.out.println( "annotation 注解为空");
            return true;
        }

        //获取用户凭证
        String token = request.getHeader(jwtUtils.getHeader());
        if(StringUtils.isBlank(token)){
            token = request.getParameter(jwtUtils.getHeader());
        }

        System.out.println("拦截获取token"+token);
        //凭证为空
        if(StringUtils.isBlank(token)){
            throw new RRException(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
        }

        Claims claims = jwtUtils.getClaimByToken(token);
        //token是通过user_id（唯一）生成的，所以对应的用户也是唯一的
        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
            throw new RRException(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }

        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));

        return true;
    }
}
