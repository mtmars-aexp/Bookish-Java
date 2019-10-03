package org.softwire.training.bookish.models.database;

public class Transactions {
    int TransID;
    int LibraryID;
    int UserID;
    String DateOut;
    String DateIn;
    
    public int getTransID() {
        return TransID;
    }
    
    public void setTransID(int transID) {
        TransID = transID;
    }
    
    public int getLibraryID() {
        return LibraryID;
    }
    
    public void setLibraryID(int libraryID) {
        LibraryID = libraryID;
    }
    
    public int getUserID() {
        return UserID;
    }
    
    public void setUserID(int userID) {
        UserID = userID;
    }
    
    public String getDateOut() {
        return DateOut;
    }
    
    public void setDateOut(String dateOut) {
        DateOut = dateOut;
    }
    
    public String getDateIn() {
        return DateIn;
    }
    
    public void setDateIn(String dateIn) {
        DateIn = dateIn;
    }
}
