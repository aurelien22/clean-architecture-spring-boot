package com.adincuff.racingstats.horse;

import com.adincuff.racingstats.horse.application.port.out.LoadHorsesPort;
import com.adincuff.racingstats.horse.application.service.GetHorseListService;
import com.adincuff.racingstats.horse.domain.Color;
import com.adincuff.racingstats.horse.domain.Genre;
import com.adincuff.racingstats.horse.domain.Horse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

public class GetHorseListServiceShould {

    private final LoadHorsesPort loadHorsesPort = Mockito.mock(LoadHorsesPort.class);

    private final GetHorseListService getHorseListService = new GetHorseListService(loadHorsesPort);

    @Test
    void sendBackListOfHorses() {

        // Arrange

        List<Horse> horses = List.of(Horse.withId(1L, "jacasse", new Date(2019-02-12), Genre.GELDING, Color.GREY ), Horse.withId(2L, "jazzman", new Date(2019-02-12), Genre.GELDING, Color.GREY ));

        // Act

        when(loadHorsesPort.loadHorses()).thenReturn(horses);

        List<Horse> returnedHorses = getHorseListService.getHorseList();

        // Assert

        assertEquals(returnedHorses.size(), 2);
        assertEquals(returnedHorses.get(0).getName(), "jacasse");
        assertEquals(returnedHorses.get(1).getName(), "jazzman");

    }

}
