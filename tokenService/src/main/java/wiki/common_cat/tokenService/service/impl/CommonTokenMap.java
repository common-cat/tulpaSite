package wiki.common_cat.tokenService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.common_cat.tokenService.service.TokenUtil;
import wiki.common_cat.tokenService.service.TokenMap;
import wiki.common_cat.tokenService.service.TokenUser;

@Service("commonTokenMap")
public class CommonTokenMap implements TokenMap {
    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public String getToken(String id,String pwd,boolean isAccountNonExpired) {
        return tokenUtil.generateToken(new TokenUser(id,pwd,isAccountNonExpired));
    }

    @Override
    public void updateToken(String token) {
        if(tokenUtil.canRefresh(token)){
            tokenUtil.refreshToken(token);
        }
    }
    @Override
    public String getID(String token) {
        if(tokenUtil.canRefresh(token)){
            return tokenUtil.getIDByToken(token);
        }
        return "false";
    }
}
