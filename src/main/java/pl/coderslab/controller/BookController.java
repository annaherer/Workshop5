package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookService.get(bookId).get();
    }

    @PutMapping
    public void changeBook(@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping ("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.delete(bookId);
    }
}
