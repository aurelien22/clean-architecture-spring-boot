package com.adincuff.racingstats.horse.adapter.in.web;

import com.adincuff.racingstats.horse.application.port.in.RegisterHorseCommand;
import com.adincuff.racingstats.horse.application.port.in.RegisterHorseUseCase;
import com.adincuff.racingstats.horse.domain.Horse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterHorseController {

    private final RegisterHorseUseCase registerHorseUseCase;

    @PostMapping("/api/horses")
    ResponseEntity<Horse> registerHorse(
            @RequestBody RegisterHorseCommand dto
    ) {

        RegisterHorseCommand command = new RegisterHorseCommand(dto.getName(), dto.getDateOfBirth(), dto.getGenre(), dto.getColor());

        try {
            return ResponseEntity.ok(registerHorseUseCase.registerHorse(command));
        } catch (Exception e) {
           return new ResponseEntity("Cheval déjà present en base de données", HttpStatus.CONFLICT);
        }
    }
}
