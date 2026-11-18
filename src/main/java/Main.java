import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми для роботи з книгами.
 */
public class Main {

    /**
     * Запускає програму та відображає меню.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Кобзар", "Тарас Шевченко", 1840, 350.0));
        books.add(new Book("1984", "Джордж Орвелл", 1949, 280.5));
        books.add(new Book("Чистий код", "Роберт Мартін", 2008, 600.0));
        books.add(new Book("Ефективна Java", "Джошуа Блох", 2018, 750.0));

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
                    createBook(scanner, books);
                    break;

                case "2":
                    showBooks(books);
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

    /**
     * Створює нову книгу та додає її до списку.
     */
    public static void createBook(Scanner scanner, ArrayList<Book> books) {
        while (true) {
            try {
                System.out.print("Введіть назву книги: ");
                String title = scanner.nextLine();

                System.out.print("Введіть автора: ");
                String author = scanner.nextLine();

                System.out.print("Введіть рік видання: ");
                int year = Integer.parseInt(scanner.nextLine());

                System.out.print("Введіть ціну: ");
                double price = Double.parseDouble(scanner.nextLine());

                Book book = new Book(title, author, year, price);
                books.add(book);

                System.out.println("Книгу успішно створено.");
                break;

            } catch (NumberFormatException e) {
                System.out.println("Помилка: рік і ціна повинні бути числами. Спробуйте ще раз.");
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    /**
     * Виводить інформацію про всі книги.
     */
    public static void showBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Список книг порожній.");
            return;
        }

        System.out.println("\n--- СПИСОК КНИГ ---");

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
