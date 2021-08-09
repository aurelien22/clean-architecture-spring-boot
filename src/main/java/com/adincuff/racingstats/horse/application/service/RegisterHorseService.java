package com.adincuff.racingstats.horse.application.service;

import com.adincuff.racingstats.horse.application.port.in.RegisterHorseCommand;
import com.adincuff.racingstats.horse.application.port.in.RegisterHorseUseCase;
import com.adincuff.racingstats.horse.application.port.out.LoadHorseByNamePort;
import com.adincuff.racingstats.horse.application.port.out.RegisterHorsePort;
import com.adincuff.racingstats.horse.domain.Horse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterHorseService implements RegisterHorseUseCase {

    private final LoadHorseByNamePort loadHorseByNamePort;
    private final RegisterHorsePort registerHorsePort;

    @Override
    public Horse registerHorse(RegisterHorseCommand command) {


        /*
            Vérification des règles de gestion
            Ici : Lors de l'enregistrement d'un cheval en base de données, celui-ci ne doit pas déjà exister
        */

        horseNotAlreadyExists(command.getName());

        /*
            Réalisation d'une entité Horse sans id grâce aux données reçu dans la Command.
            permettant sa manipulation avant persistence
         */

        Horse horse = Horse.withoutId(command.getName(), command.getDateOfBirth(), command.getGenre(), command.getColor());

        /*
            Appel du port registerHorsePort et de sa methode saveHorse permetant la persistence de l'entité.
         */

        return registerHorsePort.saveHorse(horse);
    }

    private void horseNotAlreadyExists(String horseName) {
        if (loadHorseByNamePort.loadHorseByName(horseName)) {
            throw new IllegalArgumentException("Ce cheval est déjà présent en base de données");
        }
    }
}
