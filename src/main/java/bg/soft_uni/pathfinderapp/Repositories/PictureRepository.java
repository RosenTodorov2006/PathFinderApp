package bg.soft_uni.pathfinderapp.Repositories;
import bg.soft_uni.pathfinderapp.Model.Entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    List<Picture> findAllByTitle(String title);
}
