package bg.soft_uni.pathfinderapp.Model.Entities;

import bg.soft_uni.pathfinderapp.Model.Entities.Enums.CategoryType;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryType name;

    public Category(CategoryType name) {
        this.name = name;
    }

    public Category(String description, CategoryType name) {
        this.description = description;
        this.name = name;
    }

    public Category() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryType getName() {
        return name;
    }

    public void setName(CategoryType name) {
        this.name = name;
    }
}
