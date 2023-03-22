package mk.ukim.finki.rentabook.dataholder;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.rentabook.models.dto.AuthorDTO;
import mk.ukim.finki.rentabook.models.dto.BookDTO;
import mk.ukim.finki.rentabook.models.dto.CountryDTO;
import mk.ukim.finki.rentabook.models.enumerations.Category;
import mk.ukim.finki.rentabook.models.metamodels.Author;
import mk.ukim.finki.rentabook.models.metamodels.Book;
import mk.ukim.finki.rentabook.models.metamodels.Country;
import mk.ukim.finki.rentabook.repository.AuthorRepository;
import mk.ukim.finki.rentabook.repository.BookRepository;
import mk.ukim.finki.rentabook.repository.CountryRepository;
import mk.ukim.finki.rentabook.service.AuthorService;
import mk.ukim.finki.rentabook.service.BookService;
import mk.ukim.finki.rentabook.service.CountryService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(CountryRepository countryRepository,
                           AuthorRepository authorRepository,
                           BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        if (countryRepository.count() != 0 || authorRepository.count() != 0 || bookRepository.count() != 0) {
            return;
        }

        for (int i = 1; i < 10; i++) {
            create(i);
        }
    }

    private void create(int i) {
        Country c = new Country();
        c.setName(String.format("Country %d", i));
        c.setContinent(String.format("Continent %d", i));
        countryRepository.save(c);

        Author a = new Author();
        a.setName(String.format("Name %d", i));
        a.setSurname(String.format("Surname %d", i));
        a.setCountry(c);
        authorRepository.save(a);

        Book b = new Book();
        b.setName(String.format("Name %d", i));
        b.setCategory(Category.values()[i % Category.values().length]);
        b.setAuthor(a);
        b.setAvailableCopies(i);
        bookRepository.save(b);
    }
}
