package pl.coderslab.controller;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();

    Optional<Book> get(Long id);

    void add(Book book);

    void delete(Long id);

    void update(Book book);
}
