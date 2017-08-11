package Library;

public class Book extends LibraryItem {

    Genre bookGenre;
    String author;

    public Book(int quantityInStock, String title, String publisher, String author, Genre bookGenre) {
        super(quantityInStock, title, publisher);
        this.author = author;
        this.bookGenre = bookGenre;
    }
}
