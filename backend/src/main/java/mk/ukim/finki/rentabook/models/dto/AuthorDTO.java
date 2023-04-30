package mk.ukim.finki.rentabook.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.rentabook.models.metamodels.Country;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    Long id;
    String name;
    String surname;
    Long countryId;
}
