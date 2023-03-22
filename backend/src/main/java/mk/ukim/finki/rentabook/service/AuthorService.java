package mk.ukim.finki.rentabook.service;

import mk.ukim.finki.rentabook.models.dto.AuthorDTO;
import mk.ukim.finki.rentabook.models.metamodels.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Author addAuthor(AuthorDTO author);

    Author editAuthor(Long id, AuthorDTO author);

    void deleteAuthor(Long id);
}
