package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import pl.coderslab.model.Book;
import java.util.List;

@Controller
@RequestMapping("/adminPanel")
public class AdminPanelController {
    private final BookService bookService;

    public AdminPanelController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    String adminPanel(HttpServletRequest request) {
        List<Book> books = bookService.getBooks();
        request.setAttribute("books", books);
        return "adminPanel";
    }

    @GetMapping("addBook")
    String addBook() {
        return "addEditBook";
    }

    @PostMapping("addBook")
    String addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
        Book book = new Book(isbn, title, author, publisher, type);
        bookService.add(book);
        return "redirect:/adminPanel";
    }

    @GetMapping("displayBook/{bookId}")
    String displayBook(@PathVariable Long bookId, HttpServletRequest request) {
        Book book = bookService.get(bookId).get();
        request.setAttribute("book", book);
        return "displayBook";
    }

    @GetMapping("editBook/{bookId}")
    String editBook(@PathVariable Long bookId, HttpServletRequest request) {
        Book book = bookService.get(bookId).get();
        request.setAttribute("book", book);
        return "addEditBook";
    }

    @PostMapping("editBook")
    String editBook(@RequestParam Long id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
        Book book = new Book(id, isbn, title, author, publisher, type);
        bookService.update(book);
        return "redirect:/adminPanel";
    }

    @GetMapping("deleteBook/{bookId}")
    String deleteBook(@PathVariable Long bookId) {
        bookService.delete(bookId);
        return "redirect:/adminPanel";
    }
}
