package wiki.common_cat.staticHTMLService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.staticHTMLService.entities.Doc;
@Mapper
public interface StaticMapper {
    Doc getDoc(String id);
}
