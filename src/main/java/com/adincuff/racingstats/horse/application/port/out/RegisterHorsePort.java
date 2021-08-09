package com.adincuff.racingstats.horse.application.port.out;

import com.adincuff.racingstats.horse.domain.Horse;

public interface RegisterHorsePort {
    Horse saveHorse(Horse horse);
}
