package com.adincuff.racingstats.horse.application.port.out;

import com.adincuff.racingstats.horse.domain.Horse;

import java.util.List;

public interface LoadHorsesPort {
    List<Horse> loadHorses();
}
