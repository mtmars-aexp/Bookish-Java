
package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Transactions;
import org.softwire.training.bookish.models.page.TransactionsPageModel;
import org.softwire.training.bookish.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {

    private final TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @RequestMapping("")
    ModelAndView transactions() {


        List<Transactions> transactions = transactionsService.getAllTransactions();

        TransactionsPageModel transactionsPageModel = new TransactionsPageModel();
        transactionsPageModel.setTransactions(transactions);

        return new ModelAndView("transactions", "model", transactionsPageModel);
    }

}

