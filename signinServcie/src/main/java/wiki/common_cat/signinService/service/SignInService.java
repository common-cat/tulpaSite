package wiki.common_cat.signinService.service;




public interface SignInService {
    public String signIn(String email, String date, String pwd, String tulpas, String hosts);
    //或者"用户已存在"("existing")
    String verify(String url);
    //点击页面 进行验证
}
