package wiki.common_cat.tokenService.service;
import java.util.Map;
public interface TokenMap {
    String getToken(String id,String pwd,boolean isAccountNonExpired);
    void updateToken(String token);
    String getID(String token);
}
