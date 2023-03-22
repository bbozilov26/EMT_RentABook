package mk.ukim.finki.rentabook.service;

import mk.ukim.finki.rentabook.models.dto.AuthorDTO;
import mk.ukim.finki.rentabook.models.metamodels.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Optional<Author> addAuthor(AuthorDTO authorDTO);

    Optional<Author> editAuthor(Long id, AuthorDTO authorDTO);

    void deleteAuthor(Long id);
}
