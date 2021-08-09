package com.adincuff.racingstats.horse.adapter.out.persistence;

import com.adincuff.racingstats.horse.domain.Color;
import com.adincuff.racingstats.horse.domain.Genre;
import com.adincuff.racingstats.horse.domain.Horse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "horse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public
class HorseJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column private String name;
    @Column(name = "dateofbirth") private Date dateOfBirth;
    @Column private Genre genre;
    @Column private Color color;

    Horse asHorse() {
        return new Horse(id, name, dateOfBirth, genre, color);
    }

}
