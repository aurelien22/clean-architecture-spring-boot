package com.adincuff.racingstats.horse.application.port.in;

import com.adincuff.racingstats.horse.domain.Horse;

import java.util.List;

public interface GetHorseListQuery {

    List<Horse> getHorseList();

}
