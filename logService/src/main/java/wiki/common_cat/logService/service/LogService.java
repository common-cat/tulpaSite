package wiki.common_cat.logService.service;

public interface LogService {
    String logByID(String session,String id,String pwd);
    //返回一个token
    String logByEmail(String session,String email,String pwd);
    String sessionID(String sessionID);
}
