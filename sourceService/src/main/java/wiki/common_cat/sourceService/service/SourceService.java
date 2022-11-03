package wiki.common_cat.sourceService.service;

public interface SourceService {
    void deleteDoc(String sessionID);
    String getDoc(String id,String sessionID);
    void setDoc(String html,String sessionID);

    String setImage(String base64,String sessionID);
    byte[] getImage(String imageID);
    void deleteImage(String id, String imageID);
    String getAuditedDoc(String id);
}
