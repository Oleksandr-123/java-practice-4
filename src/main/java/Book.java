
import java.util.Objects;

/**
 * Клас, що представляє книгу.
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    /**
     * Створює книгу з перевіркою всіх значень.
     *
     * @param title назва книги
     * @param author автор книги
     * @param year рік видання
     * @param price ціна книги
     * @throws IllegalArgumentException якщо дані некоректні
     */
    public Book(String title, String author, int year, double price) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setPrice(price);
    }

    /**
     * Повертає назву книги.
     * @return назва книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Встановлює назву книги.
     * @param title назва книги
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва книги не може бути порожньою");
        }
        this.title = title;
    }

    /**
     * Повертає автора книги.
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Встановлює автора книги.
     * @param author автор книги
     */
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор не може бути порожнім");
        }
        this.author = author;
    }

    /**
     * Повертає рік видання.
     * @return рік видання
     */
    public int getYear() {
        return year;
    }

    /**
     * Встановлює рік видання.
     * @param year рік видання
     */
    public void setYear(int year) {
        if (year <= 0 || year > 2026) {
            throw new IllegalArgumentException("Некоректний рік видання");
        }
        this.year = year;
    }

    /**
     * Повертає ціну книги.
     * @return ціна книги
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну книги.
     * @param price ціна книги
     */
    public void setPrice(double price) {
        if (!Double.isFinite(price) || price <= 0) {
            throw new IllegalArgumentException("Ціна повинна бути більшою за нуль");
        }
        this.price = price;
    }

    /**
     * Повертає текстове представлення книги.
     * @return інформація про книгу
     */
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author
                + "', year=" + year + ", price=" + price + "}";
    }

    /**
     * Порівнює дві книги.
     * @param o об'єкт для порівняння
     * @return true, якщо книги однакові
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year
                && Double.compare(book.price, price) == 0
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }

    /**
     * Повертає хеш-код книги.
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, price);
    }
}
