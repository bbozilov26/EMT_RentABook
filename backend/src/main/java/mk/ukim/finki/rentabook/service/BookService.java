package mk.ukim.finki.rentabook.service;

import mk.ukim.finki.rentabook.models.dto.BookDTO;
import mk.ukim.finki.rentabook.models.metamodels.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book addBook(BookDTO book);

    Book editBook(Long id, BookDTO book);

    void deleteBook(Long id);

    void markBookAsTaken(Long id);

    List<Book> getAllBooksByPage(Pageable withPage);
}
