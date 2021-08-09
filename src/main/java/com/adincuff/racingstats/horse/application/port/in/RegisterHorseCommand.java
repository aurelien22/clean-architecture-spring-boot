package com.adincuff.racingstats.horse.application.port.in;

import com.adincuff.racingstats.common.SelfValidating;
import com.adincuff.racingstats.horse.domain.Color;
import com.adincuff.racingstats.horse.domain.Genre;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Value
@EqualsAndHashCode(callSuper = false)
public class RegisterHorseCommand extends SelfValidating<RegisterHorseCommand> {

    @NotNull String name;

    @NotNull Date dateOfBirth;

    @NotNull Genre genre;

    @NotNull Color color;

    public RegisterHorseCommand(
            String name,
            Date dateOfBirth,
            Genre genre,
            Color color) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.genre = genre;
        this.color = color;
        this.validateSelf();
    }
}
