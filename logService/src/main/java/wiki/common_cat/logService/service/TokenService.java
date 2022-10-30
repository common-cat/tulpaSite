package wiki.common_cat.logService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
@FeignClient(value = "TOKENSERVICE")
public interface TokenService {
    @GetMapping("/gettoken/")
    String getToken(@RequestBody Map<String,String> body);
    @PostMapping("/updateToken/{token}")
    void updateToken(@PathVariable("token")String token);
    //刷新token销毁时间
    @GetMapping("/getid/{token}")
    String getID(@PathVariable("token")String token);
}
