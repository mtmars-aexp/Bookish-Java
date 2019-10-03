package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Library;
import org.softwire.training.bookish.models.database.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends DatabaseService {
    public List<User> getAllUsers() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Users")
                        .mapToBean(User.class)
                        .list()
        );
    }

    public void deleteUser(int UserID) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM Users WHERE UserID = :id")
                        .bind("id", UserID)
                        .execute()
        );
    }

    public void addUser(User user) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO Users (FirstName, LastName) VALUES (:FirstName, :LastName)")
                        .bind("FirstName", user.getFirstName())
                        .bind("LastName", user.getLastName())
                        .execute()
        );
    }

    public void updateUser(User user) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE Users SET FirstName = :FirstName, LastName = :LastName WHERE UserID = :UserID")
                        .bind("FirstName", user.getFirstName())
                        .bind("LastName", user.getLastName())
                        .bind("UserID", user.getUserID())
                        .execute()
        );
    }
}
