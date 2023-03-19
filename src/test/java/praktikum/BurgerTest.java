package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(mockBun);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(mockIngredient1);
        ingredients.add(mockIngredient2);
        burger.ingredients = ingredients;
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(1.0f);
        when(mockIngredient1.getPrice()).thenReturn(0.5f);
        when(mockIngredient2.getPrice()).thenReturn(0.7f);
        float expectedPrice = 3.2f;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    @Test
    public void testGetReceipt() {
        when(mockBun.getName()).thenReturn("Bun");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getName()).thenReturn("Cheese");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getName()).thenReturn("Ketchup");
        String expectedReceipt = "(==== Bun ====)\n" +
                "= filling Cheese =\n" +
                "= sauce Ketchup =\n" +
                "(==== Bun ====)\n" +
                "\n" +
                "Price: 0,000000\n";
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void testAddIngredient() {
        Ingredient newIngredient = mock(Ingredient.class);
        burger.addIngredient(newIngredient);
        assertEquals(3, burger.ingredients.size());
        assertEquals(newIngredient, burger.ingredients.get(2));
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(0, 1);
        assertEquals(2, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }
}