package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Library;

import java.util.List;

public class CheckoutPageModel {
    private List<Library> libraryStock;

    public List<Library> getLibraryList() {
        return libraryStock;
    }

    public void setLibraryList(List<Library> libraryStock) {
        this.libraryStock = libraryStock;
    }
}