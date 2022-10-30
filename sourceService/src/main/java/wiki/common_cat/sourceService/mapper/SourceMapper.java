package wiki.common_cat.sourceService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.sourceService.entities.Doc;
import wiki.common_cat.sourceService.entities.Image;

@Mapper
public interface SourceMapper {
    Doc getDoc(String authorID);
    Image getImage(String imageID);
    String imageExist(int hash);
    void setDoc(String HTML,String authorID,String date,int status);
    void deleteDoc(String authorID);
    void setImage(String imageID,byte[] file,String date,int hash);
    void deleteImage(String authorID,String image);
    String docExist(String authorID);
    void updateDoc(String HTML,String authorID,String date,int status);
}
