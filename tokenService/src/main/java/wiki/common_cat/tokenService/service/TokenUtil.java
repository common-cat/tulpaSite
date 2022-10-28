package wiki.common_cat.tokenService.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class TokenUtil {
    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";
    @Value("${spring.jwt.secret}")
    private String secret;
    //token使用的密钥
    @Value("${spring.jwt.expiration}")
    private Long expiration;
    //token过期时间
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }
    //根据用户信息 生成token
    public String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    //生成token
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }
    //获取token的过期时间
    public String getIDByToken(String token){
        String userName;
        try{
            Claims claims=getClaimsFromToken(token);
            userName=claims.getSubject();
        }catch (Exception e){
            userName=null;
        }
        return userName;
    }
    //获取ID 根据token
    private Claims getClaimsFromToken(String token) {
        Claims claims=null;
        try {
            claims=Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return claims;
    }
    //获取载荷
    public boolean validateToken(String token,UserDetails userDetails){
        String username=getIDByToken(token);
        return username.equals(userDetails.getUsername())&&!isTokenExpired(token);
    }
    //验证是否有效
    private boolean isTokenExpired(String token) {
        Date expireDate=getExpiredDateFromToken(token);
        return  expireDate.before(new Date());
    }
    //token是否失效
    private Date getExpiredDateFromToken(String token) {
        Claims claims=getClaimsFromToken(token);
        return claims.getExpiration();
    }
    //获取token失效时间
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }
    //token是否可被刷新
    public String refreshToken(String token){
        Claims claims=getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }
    //刷新token
}
