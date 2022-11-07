package wiki.common_cat.signinService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import wiki.common_cat.signinService.entities.User;
import wiki.common_cat.signinService.mapper.SignInMapper;
import wiki.common_cat.signinService.service.EmailService;
import wiki.common_cat.signinService.service.SignInService;

import javax.annotation.Resource;
import java.util.Random;
@Service("commonSigninService")
public class CommonSignInService implements SignInService {
    @Resource(name = "commonEmailService")
    private EmailService emailService;
    @Autowired
    private SignInMapper mapper;
    @Value("${host.host}")
    private String host;
    private Jedis jedis=new Jedis("localhost");
    @Override
    public String signIn(String email, String date, String pwd, String tulpas, String hosts) {
        int salt=(new Random()).nextInt();
        if(mapper.getIDByEmail(email)!=null){
            return "existing";
        }
        String url="sign@"+String.valueOf(email.hashCode()+Math.abs((new Random().nextInt())));
        jedis.set(url,email);
        mapper.delPreUser(email);
        mapper.addPreUser(email, salt, (pwd+salt).hashCode(), tulpas, hosts);
        emailService.sendMessage("点击这里验证你的tulpa花名册邮箱 http://"+host+"/signin/verify/"+url,"tulpa花名册验证",new String[]{email});
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
        mapper.addUser(preUser.getSalt(), preUser.getPwdhash(),email);
        int id=mapper.getID();
        mapper.addDoc(id);
        System.out.println("id-sign-success:"+id);
        mapper.addImage(id+"img");
        mapper.addUserInfo(id, preUser.getTulpas(),preUser.getHosts());
        return String.valueOf("你的ID是"+id);
    }
}
