package mk.ukim.finki.rentabook.models.metamodels;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.rentabook.models.BaseEntity;
import mk.ukim.finki.rentabook.models.enumerations.Category;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mm_books")
public class Book extends BaseEntity {

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    Category category;

    @ManyToOne
    @JoinColumn(name = "mm_author_id")
    Author author;

    @Column(name = "available_copies")
    Integer availableCopies;
}
