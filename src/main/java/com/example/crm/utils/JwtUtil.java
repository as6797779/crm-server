package com.example.crm.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JwtUtil {

    private static Long expirMills = 7 * 24 * 60 * 60 * 1000L;

    private static String TOKEN_SECTURE_KEY = "RXR8C+CKv1InhjY2A3GMXEFzhiJYh3g0fHC8I19hsMU=";

    /**
     * token中含有用户信息，并使用秘钥加密
     * @param logname
     * @return
     */
    public static String generate(String logname) {

        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(TOKEN_SECTURE_KEY));

        // 现在时间即为 jwt的签发时间
        Date current = new Date();
        // 设置有效时间
        Date expirDate = new Date(current.getTime() + expirMills);

        // 存放用户信息
        Map<String, String> claims = new HashMap<>();
        claims.put("p", logname);

        String jws = Jwts.builder()
                // 设置 header
                .setHeaderParam("typ" , "JWT")
                .setHeaderParam("alg", "HS256")
                // 设置 cliaim ，自定义的数据
                .setClaims(claims)
                //iat: jwt的签发时间
                .setIssuedAt(current)
                // 有效时间
                .setExpiration(expirDate)
                // 设置签名使用的签名算法和签名使用的秘钥
                .signWith(key)
                // 主要用来作为一次性token,从而回避重复攻击。
                .setId( UUID.randomUUID().toString() )
                .compact();
        return jws;
    }

    public static void generateKey() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String secretString = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(secretString);
    }

    /**
     * 解析token字符串，使用秘钥解密
     *
     * @param token
     * @return
     */
    public static Claims parse(String token) {
        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(TOKEN_SECTURE_KEY).build().parseClaimsJws(token);
        return jws.getBody();
    }

    /**
     *自定义想要验证的东西，你存在subject里面的东西。
     * @param token
     * @return
     */
    public static Boolean isToken(String subject, String token){
        //获取解析后的属性体
        try {
            Claims claims  = null;
            claims = parse(token);
            //下面判断这个token除了格式之外你想判断的东西。测试自定义的subject为"{id:100,name:xiaohong}"
            if(subject.equals(claims.getSubject())){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 获取解析后字符串中的手机号签名信息
     *
     * @param claim
     * @return
     */
    public static String getLogname(Claims claim) {
        return (String) claim.get("p");
    }

    /**
     * 获取解析后字符串中的签发时间信息
     *
     * @param claim
     * @return
     */
    public static Date getIssuedAt(Claims claim) {
        return claim.getIssuedAt();
    }

    /**
     * 获取解析后字符串中的过期时间信息
     *
     * @param claim
     * @return
     */
    public static Date getExpiation(Claims claim) {
        return claim.getExpiration();
    }


    /**
     * 判断时间是否已经过期
     * @param expiration
     * @return
     */
    public static boolean isExpired( Date expiration ) {
        return expiration.before(new Date());
    }

    public static void main(String[] args) throws InterruptedException {

        generateKey();
        //1.生成token
        String t = generate("13663830111");
        System.out.println("t = "+ t);
        System.out.println("--------------------");

        //2.解析token，解析失败抛出异常
        Claims claims = parse(t);
        //3.成功解析后，获取签名信息
        String uphone = getLogname(claims);
        Date expiation = getExpiation(claims);
        System.out.println(uphone + "--" + expiation);

        System.out.println("------------------------------------");

    }

}
