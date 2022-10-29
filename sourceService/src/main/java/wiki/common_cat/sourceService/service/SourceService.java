package wiki.common_cat.sourceService.service;

import org.springframework.web.bind.annotation.PathVariable;
import wiki.common_cat.sourceService.entities.Music;

public interface SourceService {
    void deleteDoc(String token);
    String getDoc(String id);
    void setDoc(String token,String html);
    String setMusic(String token, String base64);
    String getMusic(String id,String musicID);
    String setImage(String token,String base64);
    String getImage(String id, String imageID);
    void deleteMusic(String id,String musicID);
    void deleteImage(String id,String imageID);
}
