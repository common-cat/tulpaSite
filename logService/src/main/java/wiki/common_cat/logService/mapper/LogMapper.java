package wiki.common_cat.logService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.logService.entities.User;
@Mapper
public interface LogMapper {
    User getUserByID(String id);
    User getUserByEmail(String email);
    void setUser(long lastLoginDate,int status,int loginTimes,String id);
}
