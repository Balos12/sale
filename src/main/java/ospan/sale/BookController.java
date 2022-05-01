package ospan.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ospan.sale.Book;
import ospan.sale.BookRepository;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
