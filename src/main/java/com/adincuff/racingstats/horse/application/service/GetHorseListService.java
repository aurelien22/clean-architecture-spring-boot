package com.adincuff.racingstats.horse.application.service;

import com.adincuff.racingstats.horse.application.port.in.GetHorseListQuery;
import com.adincuff.racingstats.horse.application.port.out.LoadHorsesPort;
import com.adincuff.racingstats.horse.domain.Horse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetHorseListService implements GetHorseListQuery {

    private final LoadHorsesPort loadHorsesPort;

    @Override
    public List<Horse> getHorseList() {
        return loadHorsesPort.loadHorses();
    }
}
