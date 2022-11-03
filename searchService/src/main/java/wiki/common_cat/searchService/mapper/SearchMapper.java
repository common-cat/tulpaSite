package wiki.common_cat.searchService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.searchService.entities.User;
@Mapper
public interface SearchMapper {
    User[] search(String q);
}
