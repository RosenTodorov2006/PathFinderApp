package bg.soft_uni.pathfinderapp.Repositories;

import bg.soft_uni.pathfinderapp.Model.Entities.Enums.RoleNames;
import bg.soft_uni.pathfinderapp.Model.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleNames name);
}
