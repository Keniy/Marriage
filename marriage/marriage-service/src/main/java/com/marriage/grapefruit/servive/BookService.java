package com.marriage.grapefruit.servive;

import java.util.List;
import java.util.Optional;

import com.marriage.grapefruit.model.entity.Book;
import com.marriage.grapefruit.model.entity.BookWithBookStore;

public interface BookService {

    Optional<Book> getBookById(Long id);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByPage(Integer page, Integer perPage);

    List<String> getAllBookNames();

    Optional<BookWithBookStore> getBookWithBookStoreById(Long id);

    Integer getTotalPage(Integer perPage);

    boolean saveBook(Book book);

    boolean modifyBookOnNameById(Book book);

    boolean deleteBookById(Long id);

}
