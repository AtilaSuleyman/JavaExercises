package Library;

public class Booking {

    Customer customer;
    String dateBooked;
    String dateToReturn;
    LibraryItem item;

    public Booking(Customer customer, String dateBooked, String dateToReturn, LibraryItem item) {
        this.customer = customer;
        this.dateBooked = dateBooked;
        this.dateToReturn = dateToReturn;
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(String dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getDateToReturn() {
        return dateToReturn;
    }

    public void setDateToReturn(String dateToReturn) {
        this.dateToReturn = dateToReturn;
    }

    public LibraryItem getItem() {
        return item;
    }

    public void setItem(LibraryItem item) {
        this.item = item;
    }
}
