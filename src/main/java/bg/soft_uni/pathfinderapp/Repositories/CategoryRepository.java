package bg.soft_uni.pathfinderapp.Repositories;

import bg.soft_uni.pathfinderapp.Model.Entities.Category;
import bg.soft_uni.pathfinderapp.Model.Entities.Enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryType name);
}
