package wiki.common_cat.logService.service;

public interface LogService {
    String logByID(String id,String pwd);
    //返回一个token
    String logByEmail(String email,String pwd);
}
