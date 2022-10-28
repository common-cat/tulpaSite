package wiki.common_cat.sourceService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.sourceService.entities.Doc;
import wiki.common_cat.sourceService.entities.Image;
import wiki.common_cat.sourceService.entities.Music;

@Mapper
public interface SourceMapper {
    Doc getDoc(String authorID);

    Image getImage(String authorID, String imageID);
    Music getMusic(String authorID,String musicID);
    void setDoc(String authorID,Doc doc);
    void deleteDoc(String authorID);
    void setImage(String authorID,Image image);
    void deleteImage(String authorID,String image);
    void setMusic(String authorID,Music music);
    void deleteMusic(String authorID,String music);
}
