package mk.ukim.finki.rentabook.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.rentabook.models.enumerations.Category;
import mk.ukim.finki.rentabook.models.metamodels.Author;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    Long id;
    String name;
    Category category;
    Long authorId;
    Integer availableCopies;
}
