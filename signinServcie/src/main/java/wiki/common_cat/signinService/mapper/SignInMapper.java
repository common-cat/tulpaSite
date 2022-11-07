package wiki.common_cat.signinService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.signinService.entities.User;

@Mapper

public interface SignInMapper {
    void addPreUser(String email,int salt,int pwdhash,String tulpas,String hosts);
    String getIDByEmail(String email);
    void delPreUser(String email);
    void addUser(int salt,int pwdhash,String email);
    void addUserInfo(int  id,String tulpas,String hosts);
    void addDoc(int id);
    User getPreUser(String email);
    int getID();
    void addImage(String imgTable);
}
