package wiki.editService.service;

public interface ImageDatabaseService {
    String storeImage(String userID,String imageName,String image);
    //以base64编码存储image
    void deleteImage(String userID,String imageName);
    //删除图片
}
