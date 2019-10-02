package org.softwire.training.bookish.models.database;

public class Author {
    String firstName;
    String lastName;
    int authorID;
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAuthorID() {
        return authorID;
    }
    
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
}
