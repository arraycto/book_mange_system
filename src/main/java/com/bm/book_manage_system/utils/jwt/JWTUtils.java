package com.bm.book_manage_system.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * 实现token验证的工具类
 */
public class JWTUtils {
    private static final String SECRET = "FACE-RECOGNITION-SECRET-SOLT";
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;  //token有效时间一周

    /**
     * 登陆签发Token
     *
     * @param identity
     * @return
     */
    public static String buildToken(Identity identity) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + EXPIRE_TIME);
        return JWT.create()
                .withClaim("userId", identity.getId())
                .withArrayClaim("roles", identity.getRoles())
                .withIssuedAt(now).withExpiresAt(exp)
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static boolean verity(String token) {
        if (token == null || "".equals(token)) {
            return false;
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    /**
     * 获取角色信息
     *
     * @param token
     * @return
     */
    public static String[] getRoles(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        Claim claim = decodedJWT.getClaim("roles");
        return claim.asArray(String.class);
    }

}