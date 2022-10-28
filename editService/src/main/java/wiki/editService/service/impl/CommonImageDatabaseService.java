package wiki.editService.service.impl;

import org.springframework.stereotype.Service;
import wiki.editService.service.ImageDatabaseService;

@Service(value = "commonImageDatabaseService")
public class CommonImageDatabaseService implements ImageDatabaseService {
    @Override
    public String storeImage(String userID,String imageName, String image) {
        return "null";
    }

    @Override
    public void deleteImage(String userID,String imageName) {

    }
}
//TODO
