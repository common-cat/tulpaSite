package wiki.common_cat.privatePageService.service;

public interface PrivatePageService {
    String getUserInfo(int id);
    void setUserInfo(String sessionID,String tulpas,String hosts,String introduction);
}
