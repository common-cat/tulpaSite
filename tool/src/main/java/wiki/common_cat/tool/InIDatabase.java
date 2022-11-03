package wiki.common_cat.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import wiki.common_cat.tool.mapper.IniMapper;

@SpringBootApplication
public class InIDatabase {
    @Autowired
    IniMapper iniMapper;
    public static void main(String[] args){
        ApplicationContext applicationContext=SpringApplication.run(InIDatabase.class,args);
        applicationContext.getBean(InIDatabase.class).iniMapper.ini();
    }
}
