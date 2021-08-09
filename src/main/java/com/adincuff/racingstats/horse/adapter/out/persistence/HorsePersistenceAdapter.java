package com.adincuff.racingstats.horse.adapter.out.persistence;

import com.adincuff.racingstats.horse.application.port.out.LoadHorseByNamePort;
import com.adincuff.racingstats.horse.application.port.out.LoadHorsesPort;
import com.adincuff.racingstats.horse.application.port.out.RegisterHorsePort;
import com.adincuff.racingstats.horse.domain.Horse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class HorsePersistenceAdapter  implements
        LoadHorseByNamePort,
        RegisterHorsePort,
        LoadHorsesPort
{

    private final HorseRepository horseRepository;
    private final HorseMapper horseMapper;

    @Override
    public boolean loadHorseByName(String name) {
        return horseRepository.existsHorseByName(name);
    }

    @Override
    public Horse saveHorse(Horse horse) {

        HorseJpaEntity registeredHorse = horseRepository.save(horseMapper.mapToJpaEntity(horse));

        return horseMapper.mapToDomainEntity(registeredHorse);
    }

    @Override
    public List<Horse> loadHorses() {
        return horseRepository
                .findAll()
                .stream()
                .map(HorseJpaEntity::asHorse)
                .collect(Collectors.toList());
    }
}
