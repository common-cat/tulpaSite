package wiki.common_cat.mainPageService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class MainPageApplication {
    public static void main(String[] args){
        SpringApplication.run(MainPageApplication.class,args);
    }
}
