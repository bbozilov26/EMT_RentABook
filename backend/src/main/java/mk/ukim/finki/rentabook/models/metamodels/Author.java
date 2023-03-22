package mk.ukim.finki.rentabook.models.metamodels;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.rentabook.models.BaseEntity;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mm_authors")
public class Author extends BaseEntity {

    @Column(name = "surname")
    String surname;

    @ManyToOne
    @JoinColumn(name = "mm_country_id")
    Country country;
}
