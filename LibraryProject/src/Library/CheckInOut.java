package Library;

public interface CheckInOut {

    public boolean checkInLibraryItem(String itemType, LibraryItem libraryItem);
    public LibraryItem checkOutLibraryItem(String itemType, LibraryItem libraryItem);

}
