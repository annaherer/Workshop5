package pl.coderslab.controller;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {
    private List<Book> books;
    private static Long nextId = 1L;

    public MockBookService() {
        books = new ArrayList<Book>();

        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
        nextId = 4L;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Optional<Book> get(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public void add(Book book) {
        book.setId(nextId++);
        Optional<Book> existingBook = books.stream().filter(nextBook -> nextBook.getId().equals(book.getId())).findFirst();

        if (existingBook.isEmpty())
            books.add(book);
    }

    public void delete(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public void update(Book book) {
        Optional<Book> existingBook = books.stream().filter(nextBook -> nextBook.getId().equals(book.getId())).findFirst();

        if (existingBook.isPresent()) {
            existingBook.get().setIsbn(book.getIsbn());
            existingBook.get().setTitle(book.getTitle());
            existingBook.get().setAuthor(book.getAuthor());
            existingBook.get().setPublisher(book.getPublisher());
            existingBook.get().setType(book.getType());
        }
    }
}
