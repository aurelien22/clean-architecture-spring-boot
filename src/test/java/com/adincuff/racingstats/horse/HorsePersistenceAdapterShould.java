package com.adincuff.racingstats.horse;

import com.adincuff.racingstats.horse.adapter.out.persistence.HorseJpaEntity;
import com.adincuff.racingstats.horse.adapter.out.persistence.HorseMapper;
import com.adincuff.racingstats.horse.adapter.out.persistence.HorsePersistenceAdapter;
import com.adincuff.racingstats.horse.adapter.out.persistence.HorseRepository;
import com.adincuff.racingstats.horse.domain.Color;
import com.adincuff.racingstats.horse.domain.Genre;
import com.adincuff.racingstats.horse.domain.Horse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({HorsePersistenceAdapter.class, HorseMapper.class})
class HorsePersistenceAdapterShould {

    @Autowired
    private HorsePersistenceAdapter horsePersistenceAdapter;

    @Autowired
    private HorseRepository horseRepository;

    @Test
    @Sql(scripts = {"/horsePersistenceAdapterTest.sql"})
    void loadHorses() {

        List<Horse> horses = horsePersistenceAdapter.loadHorses();

        assertEquals(horses.size(), 2);
        assertEquals(horses.get(0).getName(), "jacasse");
        assertEquals(horses.get(1).getName(), "jazzman");
    }

    @Test
    void saveHorse() {

        List<HorseJpaEntity> horses;

        Horse horse = Horse.withoutId("jakyria", new Date(2019-05-23), Genre.FEMALE, Color.BAY);

        horsePersistenceAdapter.saveHorse(horse);

        horses = horseRepository.findAll();

        assertEquals(horses.size(), 1);
        assertEquals(horses.get(0).getName(), "jakyria");

    }

}
