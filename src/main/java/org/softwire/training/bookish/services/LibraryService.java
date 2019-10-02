package org.softwire.training.bookish.services;

import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class LibraryService extends DatabaseService {
    public List<Library> getAllLibraryStock() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT LibraryID l_LibraryID, Books.BookName b_bookName, Authors.FirstName a_firstName , Authors.LastName a_lastName FROM Library LEFT JOIN Books ON Library.BookID = Books.BookID LEFT JOIN Authors ON Books.AuthorID = Authors.AuthorID")
                        .registerRowMapper(BeanMapper.factory(Library.class, "l"))
                        .registerRowMapper(BeanMapper.factory(Book.class, "b"))
                        .registerRowMapper(BeanMapper.factory(Author.class, "a"))
                        .reduceRows(new ArrayList<>(), //Keeping running total as iterate over all rows.
                                (list, rowView) -> {
                                    Library library = rowView.getRow(Library.class);
                                    library.setBook(rowView.getRow(Book.class)); //Returns a book with properties found via BeanMapper.factory
                                    library.setAuthor(rowView.getRow(Author.class));
                                    list.add(library);

                                    return list;
                                })
        );
    }
}
