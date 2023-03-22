package mk.ukim.finki.rentabook.service;

import mk.ukim.finki.rentabook.models.dto.BookDTO;
import mk.ukim.finki.rentabook.models.metamodels.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Optional<Book> addBook(BookDTO bookDTO);

    Optional<Book> editBook(Long id, BookDTO bookDTO);

    void deleteBook(Long id);

    void markBookAsTaken(Long id);

    List<Book> getAllBooksByPage(Pageable withPage);
}
