
package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.Library;
import org.softwire.training.bookish.models.page.CheckoutPageModel;
import org.softwire.training.bookish.services.BookService;
import org.softwire.training.bookish.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/checkout")

public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @RequestMapping("")
    ModelAndView books(@RequestParam String frick){
        List<Library> libraryStock = checkoutService.getSelectedLibraryStock(frick);

        CheckoutPageModel checkoutPageModel = new CheckoutPageModel();
        checkoutPageModel.setLibraryList(libraryStock);

        return new ModelAndView("checkout", "model", checkoutPageModel);

    }
}

