package com.adincuff.racingstats.horse.application.port.in;

import com.adincuff.racingstats.horse.domain.Horse;

public interface RegisterHorseUseCase {
    Horse registerHorse(RegisterHorseCommand command);
}
