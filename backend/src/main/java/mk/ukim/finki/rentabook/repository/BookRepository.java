package mk.ukim.finki.rentabook.repository;

import mk.ukim.finki.rentabook.models.metamodels.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
