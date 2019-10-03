
package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Author;
import org.softwire.training.bookish.models.page.AuthorsPageModel;
import org.softwire.training.bookish.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("")
    ModelAndView author() {


        List<Author> authors = authorService.getAllAuthor();

        AuthorsPageModel authorPageModel = new AuthorsPageModel();
        authorPageModel.setAuthors(authors);

        return new ModelAndView("author", "model", authorPageModel);
    }

    @RequestMapping("/delete-author")
    RedirectView deleteLibrary(@RequestParam int AuthorID) {

        authorService.deleteAuthor(AuthorID);

        return new RedirectView("/author");
    }

    @RequestMapping("/add-author")
    RedirectView addStock(@ModelAttribute Author author) {

        authorService.addAuthor(author);

        return new RedirectView("/author");
    }

    @RequestMapping("/update-author")
    RedirectView updateAuthor(@ModelAttribute Author author) {

        authorService.updateAuthor(author);

        return new RedirectView("/author");
    }


}

