package bg.soft_uni.pathfinderapp.Repositories;

import bg.soft_uni.pathfinderapp.Model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
    Optional<User> findByEmail(String name);
}
