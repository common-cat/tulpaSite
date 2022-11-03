package wiki.common_cat.mainPageService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.mainPageService.entities.User;

@Mapper
public interface MainPageMapper {
    String[] getRandomDocs(int pages);
    User getUserInfo(int id);
}
