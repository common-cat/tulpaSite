package wiki.common_cat.sourceService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.sourceService.entities.Doc;
import wiki.common_cat.sourceService.entities.Image;

@Mapper
public interface SourceMapper {
    String isAdmin(int id);
    Doc getDoc(int id);
    Image getImage(String imgTable,int imageID);
    String imageExist(String imgTable,int hash);
    void setDoc(String HTML,int authorID);
    void deleteDoc(int id);
    void setImage(String imgTable,byte[] file,int hash);
    String docExist(int authorID);
    void updateDoc(String HTML,int id);
    String getAuditedDoc(int id);
    int getImageID();
}
