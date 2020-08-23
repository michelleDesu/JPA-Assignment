package se.lexicon.michelle.JPAAssignment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;

    @ManyToMany
            (cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            } ,
                    fetch = FetchType.LAZY
            )
    //@JoinColumn(name = "recipe_id")
    private List<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(String category, List<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return categoryId == that.categoryId &&
                Objects.equals(category, that.category) &&
                Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, category, recipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" + "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
