package de.ait.books.repository;

import de.ait.books.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findByIsbn(Long isbn);
    boolean createNewBook (Book book);
    boolean removeBook (Book book);

}