package se.lexicon.michelle.JPAAssignment.entity;

import java.util.Objects;

public class RecipeIngredient {
    private String recipeIngredientID;
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    Reciepe reciepe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement, Reciepe reciepe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.reciepe = reciepe;
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

    public Reciepe getRecipe() {
        return reciepe;
    }

    public void setRecipe(Reciepe reciepe) {
        this.reciepe = reciepe;
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
                Objects.equals(reciepe, that.reciepe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientID, ingredient, amount, measurement, reciepe);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" + "recipeIngredientID='" + recipeIngredientID + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", reciepe=" + reciepe +
                '}';
    }
}
