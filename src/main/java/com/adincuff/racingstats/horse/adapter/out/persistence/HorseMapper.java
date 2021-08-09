package com.adincuff.racingstats.horse.adapter.out.persistence;

import com.adincuff.racingstats.horse.domain.Horse;
import org.springframework.stereotype.Component;

@Component
public class HorseMapper {

    HorseJpaEntity mapToJpaEntity(Horse horse) {
        return new HorseJpaEntity(
                horse.getId(),
                horse.getName(),
                horse.getDateOfBirth(),
                horse.getGenre(),
                horse.getColor()
        );
    }

    Horse mapToDomainEntity(HorseJpaEntity horse) {
        return Horse.withId(
                horse.getId(),
                horse.getName(),
                horse.getDateOfBirth(),
                horse.getGenre(),
                horse.getColor()
        );
    }
}
