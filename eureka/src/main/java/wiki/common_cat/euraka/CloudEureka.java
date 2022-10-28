package wiki.common_cat.euraka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEureka {

    public static void main(String[] args) {
        SpringApplication.run(CloudEureka.class, args);
    }
}