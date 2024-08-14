package de.ait.books.repository;

import de.ait.books.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements BookRepository {

    private List<Book> db = new ArrayList<>( List.of(
            new Book(1222333111L, "Harry Potter", "J.K.Rowling"),
            new Book(1222333222L,  "Atomic Habits", "J.Clear"),
            new Book(1222333333L, "Queens Gambit", "W.Tevis"),
            new Book(1222333444L, "The Alchemist", "P.Coelho")
    ));


    @Override
    public List<Book> findAll() {
        return new ArrayList<>(db);
    }

    @Override
    public Book findByIsbn(Long isbn) {
        return findAll()
                .stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean createNewBook(Book book) {
        if(findByIsbn(book.getIsbn()) == null){
            db.add(book);
            return true;
        } else{
            System.out.println("Book already exists");
            return false;
        }
    }

    @Override
    public boolean removeBook(Book book) {
        return db.remove(book);
    }
}