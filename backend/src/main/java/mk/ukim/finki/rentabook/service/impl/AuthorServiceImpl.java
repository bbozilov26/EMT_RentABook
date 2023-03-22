package mk.ukim.finki.rentabook.service.impl;

import mk.ukim.finki.rentabook.exceptions.AuthorDoesNotExistException;
import mk.ukim.finki.rentabook.models.dto.AuthorDTO;
import mk.ukim.finki.rentabook.models.metamodels.Author;
import mk.ukim.finki.rentabook.models.metamodels.Country;
import mk.ukim.finki.rentabook.repository.AuthorRepository;
import mk.ukim.finki.rentabook.service.AuthorService;
import mk.ukim.finki.rentabook.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(AuthorDoesNotExistException::new);
    }

    @Override
    public Author addAuthor(AuthorDTO author) {
        Author a = new Author();
        return saveAuthor(author, a);
    }

    @Override
    public Author editAuthor(Long id, AuthorDTO author) {
        Author a = authorRepository.findById(id).orElseThrow(AuthorDoesNotExistException::new);

        return saveAuthor(author, a);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    private Author saveAuthor(AuthorDTO author, Author a) {
        Country c = countryService.getCountryById(author.getCountry().getId());

        a.setName(author.getName());
        a.setSurname(author.getSurname());

        if(c != null) {
            a.setCountry(c);
        }

        return authorRepository.save(a);
    }
}
