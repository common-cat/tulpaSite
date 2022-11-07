package wiki.common_cat.tool.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.tool.entities.PWD;

@Mapper
public interface Plugin0Mapper {
    PWD[] getemail();
    void setemail(String email,int pwdhash);

}
