package se.lexicon.michelle.JPAAssignment.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private String recipeIngredientID;

    @ManyToOne( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    },
            fetch = FetchType.EAGER

    )
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;

    @ManyToOne( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    },
            fetch = FetchType.EAGER

    )
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement, Recipe reciepe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = reciepe;
    }

    public String getRecipeIngredientID() {
        return recipeIngredientID;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(recipeIngredientID, that.recipeIngredientID) &&
                Objects.equals(ingredient, that.ingredient) &&
                measurement == that.measurement &&
                Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientID, ingredient, amount, measurement, recipe);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" + "recipeIngredientID='" + recipeIngredientID + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", reciepe=" + recipe +
                '}';
    }
}
