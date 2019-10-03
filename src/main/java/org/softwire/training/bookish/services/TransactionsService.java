package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Transactions;
import org.softwire.training.bookish.models.database.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService extends DatabaseService {
    public List<Transactions> getAllTransactions() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM Transactions")
                        .mapToBean(Transactions.class)
                        .list()
        );
    }
    
    
}
