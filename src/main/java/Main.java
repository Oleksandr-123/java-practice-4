import java.util.Scanner; 
public class Main { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        Book[] books = new Book[5]; 
        books[0] = new Book("Kobzar", "Taras Shevchenko", 1840, 350.0); 
        books[1] = new Book("1984", "George Orwell", 1949, 280.5); 
        books[2] = new Book("Clean Code", "Robert Martin", 2008, 600.0); 
        books[3] = new Book("Effective Java", "Joshua Bloch", 2018, 750.0); 
        System.out.println("Enter details for the 5th book:"); 
        System.out.print("Title: "); 
        String title = scanner.nextLine(); 
        System.out.print("Author: "); 
        String author = scanner.nextLine(); 
        System.out.print("Year: "); 
        int year = Integer.parseInt(scanner.nextLine()); 
        System.out.print("Price: "); 
        double price = Double.parseDouble(scanner.nextLine()); 
        books[4] = new Book(title, author, year, price); 
        System.out.println("\n--- All Books in Array ---"); 
        for (int i = 0; i < books.length; i++) { 
            System.out.println((i + 1) + ". " + books[i].toString()); 
        } 
        System.out.println("\nComparing book 1 and book 5 via equals: " + books[0].equals(books[4])); 
        scanner.close(); 
    } 
} 
