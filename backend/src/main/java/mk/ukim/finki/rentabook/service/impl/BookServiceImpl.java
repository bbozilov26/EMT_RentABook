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
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(BookDoesNotExistException::new);
    }

    @Override
    public Book addBook(BookDTO book) {
        Book b = new Book();
        return saveBook(book, b);
    }

    @Override
    public Book editBook(Long id, BookDTO book) {
        Book b = bookRepository.findById(id).orElseThrow(BookDoesNotExistException::new);

        return saveBook(book, b);
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

    private Book saveBook(BookDTO book, Book b) {
        Author a = authorService.getAuthorById(book.getAuthor().getId());

        b.setName(book.getName());
        b.setCategory(book.getCategory());

        if(a != null) {
            b.setAuthor(a);
        }

        b.setAvailableCopies(book.getAvailableCopies());

        return bookRepository.save(b);
    }
}
