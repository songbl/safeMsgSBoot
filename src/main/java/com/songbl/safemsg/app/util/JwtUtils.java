

package com.songbl.safemsg.app.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt工具类
 *
 */
@Component
@ConfigurationProperties(prefix = "rest.jwt")
public class JwtUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String secret ;
    private long expire;
    private String header;

    /**
     *
     * 生成jwt token
     *
     *   第一部分：Header
     *      由两部分组成，alg（算法）与type（类型）
     *
     *  JWT第二部分是：Payload
     *      是主体信息组成，用于存储JWT的基本信息，或者我们的信息
     *      例如：
     *          {
     *            "sub": "1234567890",  //token的所有人
     *            "name": "John Doe",  //所有人的名字
     *            "admin": true        //是否是管理员角色
     *            }
     *       它的json结构实际上是对JWT要传递的数据的一组声明，这些声明被称为Claims，属性值对
     *   第三部分：签名
     */
    public String generateToken(long userId) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

   //json结构
    public Claims getClaimByToken(String token) {
        System.out.println("Claims ==========");
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            logger.debug("validate is token error ", e);
            return null;
        }
    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
