package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService extends DatabaseService {
    public List<Author> getAllAuthor() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Authors")
                        .mapToBean(Author.class)
                        .list()
        );
    }

    public void deleteAuthor(int AuthorID) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM Authors WHERE AuthorID = :id")
                        .bind("id", AuthorID)
                        .execute()
        );
    }

    public void addAuthor(Author author) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO Authors (FirstName, LastName) VALUES (:FirstName, :LastName)")
                        .bind("FirstName", author.getFirstName())
                        .bind("LastName", author.getLastName())
                        .execute()
        );
    }

    public void updateAuthor(Author author) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE Authors SET FirstName = :FirstName, LastName = :LastName WHERE AuthorID = :AuthorID")
                        .bind("FirstName", author.getFirstName())
                        .bind("LastName", author.getLastName())
                        .bind("AuthorID", author.getAuthorID())
                        .execute()
        );
    }
}
