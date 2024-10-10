package bg.soft_uni.pathfinderapp.Init;
import bg.soft_uni.pathfinderapp.Model.Entities.Category;
import bg.soft_uni.pathfinderapp.Model.Entities.Enums.CategoryType;
import bg.soft_uni.pathfinderapp.Repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CategoryInit implements CommandLineRunner {
        private final CategoryRepository categoryRepository;

    public CategoryInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count()==0){
            Arrays.stream(CategoryType.values()).forEach(categoryType -> {
                this.categoryRepository.save(new Category(categoryType));
            });
        }
    }
}
