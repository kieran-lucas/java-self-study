class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class BookDisplayer {
    public void displayInfo(Book book) {
        System.out.println("Book: " + book.title + " by " + book.author);
    }
}

class BookFileSaver {
    public void saveToFile(Book book) {
        System.out.println("Saving book to file: " + book.title);
    }
}

class BookEmailSender {
    public void sendToEmail(Book book) {
        System.out.println("Sending book to email: " + book.title);
    }
}

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Java", "Kieran");

        BookDisplayer displayer = new BookDisplayer();
        displayer.displayInfo(book);

        BookFileSaver fileSaver = new BookFileSaver();
        fileSaver.saveToFile(book);

        BookEmailSender emailSender = new BookEmailSender();
        emailSender.sendToEmail(book);
    }
}
