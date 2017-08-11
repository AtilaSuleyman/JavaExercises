package Library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Library implements CheckInOut{

    private ArrayList<Customer> registeredCustomers;
    private HashMap<String, ArrayList<LibraryItem>> libraryCatalog;
    private HashMap<String, ArrayList<LibraryItem>> checkOutItems;

    public Library() {
        registeredCustomers = new ArrayList<>();
        libraryCatalog = new HashMap<>();
        checkOutItems = new HashMap<>();
        initialiseLibraryItems();
    }

    public void registerCustomer(Customer c){
        registeredCustomers.add(c);
    }

    public Customer getCustomer(String name){
        Customer requestedCustomer = null;
        for (Customer c: registeredCustomers) {
            if(c.getName().equalsIgnoreCase(name)){
                requestedCustomer = c;
                return c;
            }
        }
        return requestedCustomer;
    }

    public Customer getCustomer(String name, String jobTitle){
        Customer requestedCustomer = null;
        for (Customer c: registeredCustomers) {
            if(c.getName().equalsIgnoreCase(name)){
                if(c.getJobTitle().equalsIgnoreCase(jobTitle)){
                    requestedCustomer = c;
                    return c;
                }
            }
        }
        return requestedCustomer;
    }

    public void deleteCustomerByName(String name){
        if(!registeredCustomers.isEmpty()){
            Iterator itr = registeredCustomers.iterator();
            while(itr.hasNext()){
                Customer customer = (Customer) itr.next();
                if(customer.getName().equalsIgnoreCase(name)){
                    itr.remove();
                    System.out.println("your customer was removed!");
                }
            }
        }
    }

    public void updateCustomer(Customer updatedCustomer, String oldCustomerName){
        for(int i = 0; i<registeredCustomers.size();i++){
            if(registeredCustomers.get(i).getName().equalsIgnoreCase(oldCustomerName)){
                registeredCustomers.set(i,updatedCustomer);
            }
        }
    }

    public void addLibraryItem(String libraryItemType, LibraryItem item){
        ArrayList<LibraryItem> itemsOfType = getLibraryCatalog().get(libraryItemType);
        itemsOfType.add(item);
    }

    public void deleteLibraryItemByName(String libraryItemType, String name){
        ArrayList<LibraryItem> itemsOfType = getLibraryCatalog().get(libraryItemType);
        if(!itemsOfType.isEmpty()){
            Iterator itr = itemsOfType.iterator();
            while(itr.hasNext()){
                LibraryItem item = (LibraryItem) itr.next();
                if(item.getTitle().equalsIgnoreCase(name)){
                    itr.remove();
                    System.out.println("your customer was removed!");
                }
            }
        }
    }

    public void reduceStock(String itemType, String title){
        ArrayList<LibraryItem> itemsOfType = getLibraryCatalog().get(itemType);
        for (LibraryItem item: itemsOfType) {
            if(item.getTitle().equalsIgnoreCase(title)){
                item.setQuantityInStock(item.getQuantityInStock()-1);
            }
        }
    }

    public void incrementStock(String itemType, String title){
        ArrayList<LibraryItem> itemsOfType = getLibraryCatalog().get(itemType);
        for (LibraryItem item: itemsOfType) {
            if(item.getTitle().equalsIgnoreCase(title)){
                item.setQuantityInStock(item.getQuantityInStock()+1);
            }
        }
    }

    public void updateLibraryItem(String newItemType, LibraryItem newItem, String title){
        ArrayList<LibraryItem> itemsOfType = getLibraryCatalog().get(newItemType);
        for(int i = 0; i<itemsOfType.size();i++){
            if(itemsOfType.get(i).getTitle().equalsIgnoreCase(title)){
                itemsOfType.set(i, newItem);
            }
        }
    }

    public void initialiseLibraryItems(){

        ArrayList<LibraryItem> books = new ArrayList<>();
        ArrayList<LibraryItem> maps = new ArrayList<>();
        ArrayList<LibraryItem> newspaper = new ArrayList<>();
        Book book = new Book(5,"Timmeys Adventures", "Pearson", "Jimmy Quinn", Genre.ACTION);
        Book book1 = new Book(5,"Hallabaloo", "Peguin", "Terry Quinn", Genre.MYSTERY);
        books.add(book);
        books.add(book1);
        libraryCatalog.put("Books",books);
        libraryCatalog.put("Maps", maps);
        libraryCatalog.put("Newspaper", newspaper);
    }

    public void writeLibraryCatalogToFile(){

        try{
            String filename = "LibraryCatalog.txt";
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String key : libraryCatalog.keySet()) {
                bw.write(key+"\n");
                ArrayList<LibraryItem> specificItemCatalog = libraryCatalog.get(key);
                if(!specificItemCatalog.isEmpty()){
                    for (LibraryItem item: specificItemCatalog) {
                        bw.write("Item name: "+item.getTitle()+", "+"Item Quantity: "+item.getQuantityInStock()+"\n");
                    }
                }
            }
            bw.close();
            System.out.println("DONE!");
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean checkInLibraryItem(String itemType, LibraryItem libraryItem) {
        int index = 0;
        boolean found = false;
        ArrayList<LibraryItem> itemSpecificList = getLibraryCatalog().get(itemType);
        while (index != itemSpecificList.size() && !found) {
            if (itemSpecificList.get(index).getTitle().equalsIgnoreCase(libraryItem.getTitle())) {
                found = true;
                incrementStock(itemType, libraryItem.getTitle());
                System.out.println("You have checked in " + libraryItem.getTitle());
                return found;
            }
            index++;
        }
        if (!found) {
            System.out.println("Your book (" + libraryItem.getTitle() + ") is not registered here!");
        }
        return found;
    }

    @Override
    public LibraryItem checkOutLibraryItem(String itemType, LibraryItem libraryItem) {
        int index = 0;
        boolean found = false;
        ArrayList<LibraryItem> itemSpecificList = getLibraryCatalog().get(itemType);
        while (index != itemSpecificList.size() && !found) {
            if (itemSpecificList.get(index).getTitle().equalsIgnoreCase(libraryItem.getTitle()) &&
                    itemSpecificList.get(index).getQuantityInStock() != 0) {
                found = true;
                reduceStock(itemType, libraryItem.getTitle());
                System.out.println("You have checked out " + libraryItem.getTitle());
                return itemSpecificList.get(index);
            }
            index++;
        }
        if (!found) {
            System.out.println("Your book (" + libraryItem.getTitle() + ") is out of stock!");
        }
        return null;
    }


    public ArrayList<Customer> getRegisteredCustomers() {
        return registeredCustomers;
    }

    public void setRegisteredCustomers(ArrayList<Customer> registeredCustomers) {
        this.registeredCustomers = registeredCustomers;
    }

    public HashMap<String, ArrayList<LibraryItem>> getLibraryCatalog() {
        return libraryCatalog;
    }

    public void setLibraryCatalog(HashMap<String, ArrayList<LibraryItem>> libraryCatalog) {
        this.libraryCatalog = libraryCatalog;
    }

    public HashMap<String, ArrayList<LibraryItem>> getCheckOutItems() {
        return checkOutItems;
    }

    public void setCheckOutItems(HashMap<String, ArrayList<LibraryItem>> checkOutItems) {
        this.checkOutItems = checkOutItems;
    }

}
