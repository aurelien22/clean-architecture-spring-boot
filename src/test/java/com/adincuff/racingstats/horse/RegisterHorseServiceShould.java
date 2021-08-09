package com.adincuff.racingstats.horse;

import com.adincuff.racingstats.horse.application.port.in.RegisterHorseCommand;
import com.adincuff.racingstats.horse.application.port.out.LoadHorseByNamePort;
import com.adincuff.racingstats.horse.application.port.out.RegisterHorsePort;
import com.adincuff.racingstats.horse.application.service.RegisterHorseService;
import com.adincuff.racingstats.horse.domain.Color;
import com.adincuff.racingstats.horse.domain.Genre;
import com.adincuff.racingstats.horse.domain.Horse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Date;

public class RegisterHorseServiceShould {

    private final RegisterHorsePort registerHorsePort = Mockito.mock(RegisterHorsePort.class);

    private final LoadHorseByNamePort loadHorseByNamePort = Mockito.mock(LoadHorseByNamePort.class);

    private final RegisterHorseService registerHorseService = new RegisterHorseService(loadHorseByNamePort, registerHorsePort);

    RegisterHorseCommand registerHorseCommand = new RegisterHorseCommand("jacasse", new Date(2019-02-12), Genre.GELDING, Color.GREY);

    @Test
    void sendBackAHorseIfItNotAlreadyExist() {

        // Arrange

        Horse horse = new Horse(1L, "jacasse", new Date(2019-02-12), Genre.GELDING, Color.GREY);

        when(loadHorseByNamePort.loadHorseByName(horse.getName())).thenReturn(false);
        when(registerHorsePort.saveHorse(any(Horse.class))).thenReturn(horse);

        // Act
        Horse returnedHorse = registerHorseService.registerHorse(registerHorseCommand);

        // Assert
        assertEquals(returnedHorse.getName(), "jacasse");
    }

    @Test
    void sendBackAnExceptionIfItAlreadyExist() {

        // Arrange

        Horse horse = new Horse(1L, "jacasse", new Date(2019-02-12), Genre.GELDING, Color.GREY);

        when(loadHorseByNamePort.loadHorseByName(horse.getName())).thenReturn(true);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            registerHorseService.registerHorse(registerHorseCommand);
        });

    }
}
