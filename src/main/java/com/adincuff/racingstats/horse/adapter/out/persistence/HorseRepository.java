package com.adincuff.racingstats.horse.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<HorseJpaEntity, Long> {
    boolean existsHorseByName(String name);
}
