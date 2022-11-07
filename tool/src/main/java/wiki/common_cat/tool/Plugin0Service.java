package wiki.common_cat.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import wiki.common_cat.tool.entities.PWD;
import wiki.common_cat.tool.mapper.Plugin0Mapper;

public class Plugin0Service {
    @Autowired
    private Plugin0Mapper mapper;
    public void fix(){
        for(PWD pwd:mapper.getemail()){
            mapper.setemail(pwd.getEmail(),pwd.getPwdhash());
        }
    }
}
