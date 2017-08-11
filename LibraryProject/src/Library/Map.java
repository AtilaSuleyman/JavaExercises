package Library;

public class Map extends LibraryItem {

    public enum Country {UNITED_KINGDOM, UNITED_STATES_OF_AMERICA, COLOMBIA, MEXICO, INDIA, PAKISTAN, AUSTRAILIA}

    Country c;
    String county;

    public Map(int quantityInStock, String title, String publisher, Country c, String county) {
        super(quantityInStock, title, publisher);
        this.c = c;
        this.county = county;
    }
}
