package mk.ukim.finki.rentabook.repository;

import mk.ukim.finki.rentabook.models.metamodels.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
