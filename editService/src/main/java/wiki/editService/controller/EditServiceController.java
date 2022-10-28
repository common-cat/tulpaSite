package wiki.editService.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.editService.service.ImageDatabaseService;
import wiki.editService.service.ImageResponse;
import wiki.editService.service.TokenService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

@RestController
public class EditServiceController {
    @Autowired
    private TokenService tokenService;
    @Resource(name = "commonImageDatabaseService")
    ImageDatabaseService imageDatabaseService;
    //用于上传图片
    @PostMapping("/edit/upload-image")
    public String uploadImages(HttpServletRequest httpServletRequest){
        String base64Image=httpServletRequest.getParameter("image");
        String imageName=httpServletRequest.getParameter("name");
        String token=httpServletRequest.getParameter("token");
        if(token==""){
            return "";
        }
        String userID=tokenService.getID(token);
        //TODO
        ImageResponse imageResponse=new ImageResponse();
        imageResponse.setAlt("正在加载...");
        imageResponse.setURL(imageDatabaseService.storeImage(userID,imageName,base64Image));
        String json=(new Gson()).toJson(imageResponse);
        return json;
        //TODO
    }
    //用于删除图片

    //用于获取文章
}
