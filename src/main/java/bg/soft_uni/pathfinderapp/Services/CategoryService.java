package bg.soft_uni.pathfinderapp.Services;

import bg.soft_uni.pathfinderapp.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
