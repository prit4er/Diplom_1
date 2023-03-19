package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void testIngredientGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо", 2.5f);
        assertEquals("Мясо", ingredient.getName());
    }

    @Test
    public void testIngredientGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Кетчуп", 0.5f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void testIngredientGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо", 2.5f);
        assertEquals(2.5f, ingredient.getPrice(), 0.001f);
    }

}