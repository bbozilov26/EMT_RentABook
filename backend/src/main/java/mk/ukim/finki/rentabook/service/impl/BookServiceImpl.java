package mk.ukim.finki.rentabook.service.impl;

import mk.ukim.finki.rentabook.exceptions.BookDoesNotExistException;
import mk.ukim.finki.rentabook.models.dto.BookDTO;
import mk.ukim.finki.rentabook.models.metamodels.Author;
import mk.ukim.finki.rentabook.models.metamodels.Book;
import mk.ukim.finki.rentabook.repository.BookRepository;
import mk.ukim.finki.rentabook.service.AuthorService;
import mk.ukim.finki.rentabook.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> addBook(BookDTO bookDTO) {
        Book b = new Book();
        return Optional.of(saveBook(bookDTO, b));
    }

    @Override
    public Optional<Book> editBook(Long id, BookDTO bookDTO) {
        Book b = bookRepository.findById(id).orElseThrow(BookDoesNotExistException::new);

        return Optional.of(saveBook(bookDTO, b));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void markBookAsTaken(Long id) {
        Book b = bookRepository.findById(id).orElseThrow(BookDoesNotExistException::new);
        b.setAvailableCopies(b.getAvailableCopies() - 1);

        bookRepository.save(b);
    }

    @Override
    public List<Book> getAllBooksByPage(Pageable withPage) {
        return bookRepository.findAll(withPage).getContent();
    }

    private Book saveBook(BookDTO bookDTO, Book b) {
        Optional<Author> a = authorService.getAuthorById(bookDTO.getAuthorId());

        b.setName(bookDTO.getName());
        b.setCategory(bookDTO.getCategory());

        a.ifPresent(b::setAuthor);

        b.setAvailableCopies(bookDTO.getAvailableCopies());

        return bookRepository.save(b);
    }
}
