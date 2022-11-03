package wiki.common_cat.searchService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.common_cat.searchService.entities.User;
import wiki.common_cat.searchService.mapper.SearchMapper;
import wiki.common_cat.searchService.service.SearchService;

@Service("commonSearchService")
public class CommonSearchService implements SearchService {
    @Autowired
    private SearchMapper mapper;
    @Override
    public String search(String q) {
        User[] usrs=mapper.search("%"+q+"%");
        String[] strs=new String[usrs.length];
        for(int i=0;i< usrs.length;i++){
            strs[i]=(new Gson()).toJson(usrs[i]);
        }
        return (new Gson()).toJson(strs);
    }
}
