package se.lexicon.michelle.JPAAssignment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;

    private String recipeName;

    @OneToMany ( mappedBy = "recipe",
            cascade  ={
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    } ,
            fetch = FetchType.LAZY
    )
    private List<RecipeIngredient> recipeIngredients;

    @OneToOne(cascade ={
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    } ,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany
            (
                    mappedBy = "recipes",
                    cascade ={
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            } ,
                    fetch = FetchType.LAZY
            )
    private List<RecipeCategory> categories;

    public Recipe() {
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                Objects.equals(recipeName, recipe.recipeName) &&
                Objects.equals(recipeIngredients, recipe.recipeIngredients) &&
                Objects.equals(instruction, recipe.instruction) &&
                Objects.equals(categories, recipe.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, recipeIngredients, instruction, categories);
    }

    @Override
    public String toString() {
        return "Recipe{" + "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", instruction=" + instruction +
                ", categories=" + categories +
                '}';
    }
}
