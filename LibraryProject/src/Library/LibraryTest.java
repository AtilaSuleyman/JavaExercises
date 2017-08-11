package Library;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {

    //Library Class tests
    @org.junit.Test
    public void registerCustomerTest() throws Exception {
        Library l = new Library();
        Customer c = new Customer("Armani Suleyman", 22, "Consultant");
        c.setLibrary(l);
        c.register();
        assertTrue(!l.getRegisteredCustomers().isEmpty());
        assertTrue(l.getRegisteredCustomers().get(0).getName().equalsIgnoreCase("Armani Suleyman"));
    }

    @org.junit.Test
    public void deleteCustomerByNameTest() throws Exception {
        Library l = new Library();
        Customer c = new Customer("Armani Suleyman", 22, "Consultant");
        c.setLibrary(l);
        c.register();
        l.deleteCustomerByName("Armani Suleyman");
        assertTrue(l.getRegisteredCustomers().isEmpty());
    }

    @org.junit.Test
    public void updateCustomerTest() throws Exception {
        Library l = new Library();
        Customer c = new Customer("Armani Suleyman", 22, "Consultant");
        c.setLibrary(l);
        c.register();
        Customer newCustomer = new Customer("Alexis Granger", 32, "HR");
        newCustomer.setLibrary(l);
        newCustomer.register();
        l.updateCustomer(newCustomer,c.getName());
        assertTrue(l.getRegisteredCustomers().get(0).getName().equalsIgnoreCase("Alexis Granger"));
    }

    @org.junit.Test
    public void addLibraryItemTest() throws Exception {
        Library l = new Library();
        l.initialiseLibraryItems();
        Book book = new Book(5,"Mama Sitas", "Narcos", "Victor Valdes", Genre.MYSTERY);
        l.addLibraryItem("Books", book);
        assertTrue(l.getLibraryCatalog().get("Books").size() == 3);
    }

    @org.junit.Test
    public void deleteLibraryItemByNameTest() throws Exception {
        Library l = new Library();
        l.initialiseLibraryItems();
        assertTrue(!l.getLibraryCatalog().isEmpty());
        l.deleteLibraryItemByName("Books","Marlyn Manson");
        ArrayList<LibraryItem> books = l.getLibraryCatalog().get("Books");
        boolean exists = false;
        if(!books.isEmpty()){
            for (LibraryItem b:books) {
                if(b.getTitle().equalsIgnoreCase("Marlyn Manson")){
                    exists = true;
                    break;
                }
            }
        }
        assertTrue(!exists);
    }

    @org.junit.Test
    public void updateLibraryItemTest() throws Exception {
        Library l = new Library();
        l.initialiseLibraryItems();
        Book book = new Book(5,"Mama Sitas", "Narcos", "Victor Valdes", Genre.MYSTERY);
        l.updateLibraryItem("Books", book,"Timmeys Adventures");
        assertTrue(l.getLibraryCatalog().get("Books").get(0).getTitle().equalsIgnoreCase("Mama Sitas"));
    }


    @org.junit.Test
    public void initialiseLibraryItemTest() throws Exception {
        Library l = new Library();
        l.initialiseLibraryItems();
        ArrayList<LibraryItem> maps = l.getLibraryCatalog().get("Maps");
        assertTrue(maps.isEmpty());
    }

    //Customer class tests
    @org.junit.Test
    public void checkInTest() throws Exception {
        Library l = new Library();
        l.initialiseLibraryItems();
        Customer c = new Customer("Armani Suleyman", 22, "Consultant");
        c.setLibrary(l);
        c.register();
        Book book = new Book(5,"Mama Sitas", "Narcos", "Victor Valdes", Genre.MYSTERY);
        l.addLibraryItem("Books",book);
        c.checkOutItemTrigger("Books",book);
        c.checkInItemTrigger("Books",book);
        assertTrue(c.getCheckedOutItems().get("Books").isEmpty());
    }

    @org.junit.Test
    public void checkOutTest() throws Exception {
        Library l = new Library();
        l.initialiseLibraryItems();
        Customer c = new Customer("Armani Suleyman", 22, "Consultant");
        c.setLibrary(l);
        c.register();
        Book book = new Book(5,"Mama Sitas", "Narcos", "Victor Valdes", Genre.MYSTERY);
        l.addLibraryItem("Books",book);
        c.checkOutItemTrigger("Books",book);
        assertTrue(c.getCheckedOutItems().get("Books").get(0).getTitle().equalsIgnoreCase("Mama Sitas"));
    }
}