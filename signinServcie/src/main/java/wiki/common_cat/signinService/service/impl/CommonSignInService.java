package wiki.common_cat.signinService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import wiki.common_cat.signinService.entities.User;
import wiki.common_cat.signinService.mapper.SignInMapper;
import wiki.common_cat.signinService.service.SignInService;

import java.util.Random;
@Service("commonSigninService")
public class CommonSignInService implements SignInService {
    @Autowired
    private SignInMapper mapper;
    private Jedis jedis=new Jedis("localhost");
    @Override
    public String signIn(String email, String date, String pwd, String tulpas, String hosts) {
        int salt=(new Random()).nextInt();
        if(mapper.getIDByEmail(email)!=null){
            return "existing";
        }
        String url="sign@"+String.valueOf(email.hashCode()+(new Random().nextInt()));
        jedis.set(url,email);
        mapper.delPreUser(email);
        mapper.addPreUser(email, salt, (pwd+salt).hashCode(), tulpas, hosts);
        System.out.println("email-sign:"+email);
        //TEST
        verify(url);
        return url;
    }

    @Override
    public String verify(String url) {
        String email=jedis.get(url);
        if(email==null){
            return "wrong";
        }
        jedis.del(url);
        User preUser=mapper.getPreUser(email);
        mapper.addUser(preUser.getSalt(), preUser.getPwdhash());
        int id=mapper.getID();
        mapper.addDoc(id);
        System.out.println("id-sign-success:"+id);
        mapper.addImage(id+"img");
        mapper.addUserInfo(id, preUser.getTulpas(),preUser.getHosts());
        return String.valueOf(id);
    }
}
