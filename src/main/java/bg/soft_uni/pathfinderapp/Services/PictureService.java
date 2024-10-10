package bg.soft_uni.pathfinderapp.Services;

import bg.soft_uni.pathfinderapp.Repositories.PictureRepository;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }
}
