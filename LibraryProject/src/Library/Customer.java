package Library;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends Person{

    private HashMap<String, ArrayList<LibraryItem>> checkedOutItems;
    private String dateJoined;
    private Address address;
    private boolean registered = false;
    private Library library;

    public Customer(String name, int age, String jobTitle) {
        super(name, age, jobTitle);
        checkedOutItems = new HashMap<>();
        library = null;
        initialiseCustomer();
    }

    public void initialiseCustomer() {
        ArrayList<LibraryItem> books = new ArrayList<>();
        ArrayList<LibraryItem> maps = new ArrayList<>();
        ArrayList<LibraryItem> newspaper = new ArrayList<>();
        checkedOutItems.put("Books", books);
        checkedOutItems.put("Maps", maps);
        checkedOutItems.put("Newspaper", newspaper);
    }

    public void setLibrary(Library l) {
        library = l;
        registered = true;
    }

    public void register() {
        registered = true;
        library.registerCustomer(this);
    }


    public void checkInItemTrigger(String itemType, LibraryItem libraryItem) {
        if (registered) {
            if(library.checkInLibraryItem(itemType, libraryItem)){
                ArrayList<LibraryItem> bookCatalog = checkedOutItems.get(itemType);
                bookCatalog.remove(libraryItem);
            }
            else{
                System.out.println("Your item is not registered with the library!");
            }
        } else {
            System.out.println("You are currently not registered!");
        }
    }



    public void checkOutItemTrigger(String itemType, LibraryItem libraryItem) {
        ArrayList<LibraryItem> itemSpecificList = library.getLibraryCatalog().get(itemType);
        int index = 0;
        boolean found = false;
        if (registered) {
            LibraryItem itemToCheckOut = library.checkOutLibraryItem(itemType, libraryItem);
            if(itemToCheckOut!=null){
                checkedOutItems.get(itemType).add(libraryItem);
            }
            else{
                System.out.println("The library item you have requested does not exist!");
            }
        } else {
            System.out.println("You are currently not registered!");
        }
    }

    public HashMap<String, ArrayList<LibraryItem>> getCheckedOutItems() {
        return checkedOutItems;
    }
}

