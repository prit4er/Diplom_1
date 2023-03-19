package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter
    public IngredientType ingredientType;

    @Parameterized.Parameters(name = "{index}: IngredientType - {0}")
    public static Collection<IngredientType> data() {
        return Arrays.asList(IngredientType.SAUCE, IngredientType.FILLING);
    }

    @Test
    public void testToString() {
        assertEquals(ingredientType.toString(), ingredientType.name());
    }
}