package com.example.springbootsecurity.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @author zhoukai
 * jwt工具类
 */
public class JwtUtil {
    /**
     * 有效期为 60 * 60 * 1000 一个小时
     */
    public static final Long JWT_TTL = 60 * 60 * 1000L;
    /**
     * 设置秘钥明文
     */
    public static final String JWT_KEY = "zhoukai";

    public static String getUUID(){
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;
    }

    /**
     * 生成jwt
     * @param subject
     * @return
     */
    public static String createJWT(String subject){
        // 设置过期时间
        JwtBuilder builder = getJWTBuilder(subject, null, getUUID());
        return builder.compact();
    }

    /**
     * 生成jwt
     * @param subject token中存放的数据 （json格式）
     * @param ttlMillis token超时时间
     * @return
     */
    public static String createJWT(String subject, Long ttlMillis){
        JwtBuilder builder = getJWTBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    /**
     * 创建token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJWTBuilder(subject, ttlMillis, id);
        return builder.compact();
    }

    private static JwtBuilder getJWTBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }

        long expMillis = nowMillis + ttlMillis;
        Date expDate =  new Date(expMillis);
        return Jwts.builder()
                /**
                 * 唯一id
                 */
                .setId(uuid)
                /**
                 * 主题 可以是json
                 */
                .setSubject(subject)
                /**
                 *  签发者
                 */
                .setIssuer("zk")
                /**
                 * 签发时间
                 */
                .setIssuedAt(now)
                /**
                 * 使用HS256对称加密算法签名，第二个参数为秘钥
                 */
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate);

    }

    /**
     * 生成加密后的秘钥 secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
