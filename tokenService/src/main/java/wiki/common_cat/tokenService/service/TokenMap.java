package wiki.common_cat.tokenService.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
public interface TokenMap {
    String getToken(String id,String pwd,boolean isAccountNonExpired);
    void updateToken(String token);
    String getID(String token);
}
