package wiki.common_cat.auditService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuditApplication {
    public static void main(String[] args){
        SpringApplication.run(AuditApplication.class,args);
    }
}
