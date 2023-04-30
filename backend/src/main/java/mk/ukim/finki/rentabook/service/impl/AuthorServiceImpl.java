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
import java.util.Optional;

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
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> addAuthor(AuthorDTO authorDTO) {
        Author a = new Author();
        return Optional.of(saveAuthor(authorDTO, a));
    }

    @Override
    public Optional<Author> editAuthor(Long id, AuthorDTO authorDTO) {
        Author a = authorRepository.findById(id).orElseThrow(AuthorDoesNotExistException::new);

        return Optional.of(saveAuthor(authorDTO, a));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    private Author saveAuthor(AuthorDTO authorDTO, Author a) {
        Optional<Country> c = countryService.getCountryById(authorDTO.getCountryId());

        a.setName(authorDTO.getName());
        a.setSurname(authorDTO.getSurname());

        c.ifPresent(a::setCountry);

        return authorRepository.save(a);
    }
}
