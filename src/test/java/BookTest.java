
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тести для класу Book.
 */
public class BookTest {

    /**
     * Перевіряє помилку при встановленні некоректної назви.
     */
    @Test
    public void testInvalidSetter() {
        Book book = new Book("Kobzar", "Taras Shevchenko", 1840, 350.0);

        assertThrows(IllegalArgumentException.class, () -> {
            book.setTitle("");
        });
    }

    /**
     * Перевіряє помилку при створенні книги з некоректною ціною.
     */
    @Test
    public void testInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("Kobzar", "Taras Shevchenko", 1840, -100.0);
        });
    }

    /**
     * Перевіряє встановлення некоректного року та ціни.
     */
    @Test
    public void testInvalidYearAndPrice() {
        Book book = new Book("Kobzar", "Taras Shevchenko", 1840, 350.0);

        assertThrows(IllegalArgumentException.class, () -> {
            book.setYear(-100);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(0);
        });
    }
}
