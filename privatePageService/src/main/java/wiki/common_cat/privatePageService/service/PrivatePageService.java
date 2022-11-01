package wiki.common_cat.privatePageService.service;

public interface PrivatePageService {
    String getUserInfo(String id);
    void setUserInfo(String id,String tulpas,String hosts,String introduction);
}
