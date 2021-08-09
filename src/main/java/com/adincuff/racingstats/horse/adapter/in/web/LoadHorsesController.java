package com.adincuff.racingstats.horse.adapter.in.web;

import com.adincuff.racingstats.horse.application.port.in.GetHorseListQuery;
import com.adincuff.racingstats.horse.domain.Horse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoadHorsesController {

    private final GetHorseListQuery getHorseListQuery;

    @GetMapping("/api/horses")
    ResponseEntity<List<Horse>> getHorsesList() {
        return ResponseEntity.ok(getHorseListQuery.getHorseList());
    }

}
