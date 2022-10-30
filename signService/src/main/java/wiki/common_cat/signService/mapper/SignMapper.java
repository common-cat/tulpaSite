package wiki.common_cat.signService.mapper;

public interface SignMapper {
    void newUser(String id,String date,int salt,int pwdhash,long lastLoginDate,int status);
    //插入新用户
}
