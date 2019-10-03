
package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Library;
import org.softwire.training.bookish.models.page.LibraryPageModel;
import org.softwire.training.bookish.services.BookService;
import org.softwire.training.bookish.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @RequestMapping("")
    ModelAndView books() {

        System.out.println("AAAAA");

        List<Library> libraryStock = libraryService.getAllLibraryStock();

        LibraryPageModel libraryPageModel = new LibraryPageModel();
        libraryPageModel.setLibraryList(libraryStock);

        return new ModelAndView("library", "model", libraryPageModel);
        
    }
    
    @RequestMapping("/delete-library")
    RedirectView deleteLibrary(@RequestParam int libraryId) {
        
        libraryService.deleteLibrary(libraryId);
        
        return new RedirectView("/library");
    }
    
    @RequestMapping("/add-stock")
    RedirectView addStock(@ModelAttribute Library stock) {
        
        libraryService.addStock(stock);
        
        return new RedirectView("/library");
    }
}

