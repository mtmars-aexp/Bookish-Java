package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService extends DatabaseService {
    public List<Library> getAllLibraryStock() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT Library.LibraryID, Library.BookID, Books.BookName")
                        .mapToBean(Library.class)
                        .list()
        );
    }
}
