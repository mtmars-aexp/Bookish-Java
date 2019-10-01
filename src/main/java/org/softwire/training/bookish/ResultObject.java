package org.softwire.training.bookish;

public class ResultObject {

    String FirstName;
    String LastName;
    int UserID;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

}
