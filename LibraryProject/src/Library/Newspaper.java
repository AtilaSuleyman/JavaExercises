package Library;

public class Newspaper extends LibraryItem {

    enum Type {TABLOID, BROADSHEET};
    String author;
    Type t;

    public Newspaper(int quantityInStock, String title, String publisher, String author, Type t) {
        super(quantityInStock, title, publisher);
        this.author = author;
        this.t = t;
    }


}
