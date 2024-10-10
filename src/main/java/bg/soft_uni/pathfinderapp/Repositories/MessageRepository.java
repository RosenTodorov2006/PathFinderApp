package bg.soft_uni.pathfinderapp.Repositories;

import bg.soft_uni.pathfinderapp.Model.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Comment, Long> {
}
