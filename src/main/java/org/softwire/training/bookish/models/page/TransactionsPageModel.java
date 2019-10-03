package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Transactions;

import java.util.List;

public class TransactionsPageModel {
    private List<Transactions> transactions;
    
    public List<Transactions> getTransactions() {
        return transactions;
    }
    
    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
}
