package wiki.common_cat.mainPageService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.common_cat.mainPageService.entities.User;
import wiki.common_cat.mainPageService.mapper.MainPageMapper;
import wiki.common_cat.mainPageService.service.MainPageService;
@Service("commonMainPageService")
public class CommonMainPageService implements MainPageService {
    @Autowired
    private MainPageMapper mapper;
    @Override
    public String randomPages(int pages) {
        int[] ids_=mapper.getRandomDocs(pages);
        int[] ids=new int[ids_.length];
        for (int i=0;i<ids.length;i++){
            ids[i]=ids_[i];
        }
        User[] users=new User[ids.length];
        for(int i=0;i< ids.length;i++){
            users[i]=mapper.getUserInfo(ids[i]);
        }
        return (new Gson()).toJson(users);
    }
}
