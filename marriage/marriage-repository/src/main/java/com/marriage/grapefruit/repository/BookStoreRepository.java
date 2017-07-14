package com.marriage.grapefruit.repository;

import java.util.List;

import com.marriage.grapefruit.model.entity.BookStore;
import com.marriage.grapefruit.model.entity.BookStoreWithBooks;

public interface BookStoreRepository {

    BookStore selectBookStoreById(Long id);

    List<BookStore> selectAllBookStores();

    BookStoreWithBooks selectBookStoreWithBooksById(Long id);

}
