package wiki.common_cat.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import wiki.common_cat.tool.mapper.Plugin0Mapper;

@SpringBootApplication
public class Plugin0 {
    public static void main(String[] args){
        ApplicationContext applicationContext= SpringApplication.run(Plugin0.class,args);
        applicationContext.getBean(Plugin0Service.class).fix();
    }
}
