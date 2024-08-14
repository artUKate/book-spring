package de.ait.books.service;

import de.ait.books.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks(String title, String author);
    boolean createNewBook(Book book);
    boolean removeBook(Long isbn);

    Book findByIsbn(Long isbn);
}