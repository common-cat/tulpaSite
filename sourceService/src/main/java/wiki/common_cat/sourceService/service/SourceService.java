package wiki.common_cat.sourceService.service;

public interface SourceService {
    void deleteDoc(String token);
    String getDoc(String id,String token);
    void setDoc(String token,String html);

    String setImage(String token,String base64);
    byte[] getImage(String imageID);
    void deleteImage(String id, String imageID);
    String completeDOC(String token);
}
