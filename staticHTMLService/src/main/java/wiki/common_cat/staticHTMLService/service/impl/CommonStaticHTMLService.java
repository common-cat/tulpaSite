package wiki.common_cat.staticHTMLService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.common_cat.staticHTMLService.entities.Doc;
import wiki.common_cat.staticHTMLService.mapper.StaticMapper;
import wiki.common_cat.staticHTMLService.service.StaticHTMLService;
@Service("commonStaticHTMLService")
public class CommonStaticHTMLService implements StaticHTMLService {
@Autowired
private StaticMapper mapper;
    @Override
    public Doc getDoc(String id) {
        return mapper.getDoc(id);
    }
}
