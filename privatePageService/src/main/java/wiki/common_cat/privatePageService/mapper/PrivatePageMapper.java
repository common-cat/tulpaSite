package wiki.common_cat.privatePageService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.privatePageService.entities.User;
@Mapper
public interface PrivatePageMapper {
    User getUserInfo(String id);
    void setUserInfo(String id,String tulpas,String hosts,String introduction);
}
