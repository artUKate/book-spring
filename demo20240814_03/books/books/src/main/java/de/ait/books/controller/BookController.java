package de.ait.books.controller;

import de.ait.books.entity.Book;
import de.ait.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks (@RequestParam(name = "title", required = false, defaultValue = "")String title,
                                @RequestParam(name = "author", required = false, defaultValue = "")String author){
        return bookService.getBooks(title, author);
    };

    @PostMapping("/books")
    public Book addBook(Book book){
        bookService.createNewBook(book);
        return book;
    }

    @GetMapping("/books/{isbn}")
    public Book getBookByIsbn(@PathVariable(name = "isbn") Long isbn){
        return bookService.findByIsbn(isbn);
    }

    @DeleteMapping("/books/{isbn}")
    public boolean deleteBookByIsbn(@PathVariable(name = "isbn") Long isbn){
        return bookService.removeBook(isbn);
    };

}