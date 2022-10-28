package wiki.editService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@FeignClient(value = "TOKENSERVICE")
public interface TokenService {
    @GetMapping("/gettoken/")
    public String getToken(@RequestBody Map<String,String> body);
    @PostMapping("/updateToken/{token}")
    public void updateToken(@PathVariable("token")String token);
    //刷新token销毁时间
    @GetMapping("/getid/{token}")
    public String getID(@PathVariable("token")String token);
}
