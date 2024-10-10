package bg.soft_uni.pathfinderapp.Repositories;
import bg.soft_uni.pathfinderapp.Model.Entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
