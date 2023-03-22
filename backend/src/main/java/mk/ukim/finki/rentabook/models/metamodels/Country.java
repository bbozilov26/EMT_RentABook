package mk.ukim.finki.rentabook.models.metamodels;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import mk.ukim.finki.rentabook.models.BaseEntity;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mm_country")
public class Country extends BaseEntity {

    @Column(name = "continent")
    String continent;
}
