
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з книгами.
 */
public class Main {

    /**
     * Запускає програму та показує меню користувачу.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Kobzar", "Taras Shevchenko", 1840, 350.0));
        books.add(new Book("1984", "George Orwell", 1949, 280.5));
        books.add(new Book("Clean Code", "Robert Martin", 2008, 600.0));
        books.add(new Book("Effective Java", "Joshua Bloch", 2018, 750.0));

        boolean running = true;

        while (running) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Створити книгу");
            System.out.println("2. Показати всі книги");
            System.out.println("3. Вийти");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Назва книги: ");
                        String title = scanner.nextLine();

                        System.out.print("Автор: ");
                        String author = scanner.nextLine();

                        System.out.print("Рік видання: ");
                        int year = Integer.parseInt(scanner.nextLine());

                        System.out.print("Ціна: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        Book book = new Book(title, author, year, price);
                        books.add(book);

                        System.out.println("Книгу успішно створено!");
                    } catch (NumberFormatException e) {
                        System.out.println("Помилка: рік та ціна повинні бути числами.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("\n--- УСІ КНИГИ ---");

                    for (int i = 0; i < books.size(); i++) {
                        System.out.println((i + 1) + ". " + books.get(i));
                    }
                    break;

                case "3":
                    running = false;
                    System.out.println("Програму завершено.");
                    break;

                default:
                    System.out.println("Помилка: виберіть пункт від 1 до 3.");
            }
        }

        scanner.close();
    }
}
