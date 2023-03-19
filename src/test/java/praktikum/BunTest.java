package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testBunGetName() {
        Bun bun = new Bun("Правильное имя булочки", 1.5f);
        assertEquals("Правильное имя булочки", bun.getName());
    }

    @Test
    public void testBunGetPrice() {
        Bun bun = new Bun("Правильное имя булочки", 1.5f);
        assertEquals(1.5f, bun.getPrice(), 0);
    }

    @Test
    public void testBunConstructor() {
        Bun bun = new Bun("Правильное имя булочки", 2.0f);
        assertNotNull(bun);
        assertEquals("Правильное имя булочки", bun.getName());
        assertEquals(2.0f, bun.getPrice(), 0);
    }

}
