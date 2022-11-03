package wiki.common_cat.privatePageService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.privatePageService.entities.User;
@Mapper
public interface PrivatePageMapper {
    User getUserInfo(int id);
    void setUserInfo(int id,String tulpas,String hosts,String introduction);
}
