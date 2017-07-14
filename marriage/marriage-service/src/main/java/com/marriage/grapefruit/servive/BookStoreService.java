package com.marriage.grapefruit.servive;

import java.util.List;
import java.util.Optional;

import com.marriage.grapefruit.model.entity.BookStore;
import com.marriage.grapefruit.model.entity.BookStoreWithBooks;

public interface BookStoreService {

    Optional<BookStore> getBookStoreById(Long id);

    List<String> getAllBookStoreNames();

    Optional<BookStoreWithBooks> getBookStoreWithBooksById(Long id);

}
