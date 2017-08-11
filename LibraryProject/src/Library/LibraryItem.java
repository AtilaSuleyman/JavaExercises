package Library;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class LibraryItem {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private int quantityInStock;
    private String title;
    private String publisher;

    public LibraryItem(int quantityInStock, String title, String publisher) {
        this.id = count.incrementAndGet();
        this.quantityInStock = quantityInStock;
        this.title = title;
        this.publisher = publisher;
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
