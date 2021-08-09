package com.adincuff.racingstats.horse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Horse {

    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private Date dateOfBirth;

    @Getter
    private Genre genre;

    @Getter
    private Color color;

    /**
     * Create a horse entity without an ID. Use to create a new entity that is not yet persisted.
     */
    public static Horse withoutId(
            String name,
            Date dateOfBirth,
            Genre genre,
            Color color) {
        return new Horse(null, name, dateOfBirth, genre, color);
    }

    /**
     * Create a horse entity with an ID. Use to reconstitute a persisted entity.
     */
    public static Horse withId(
            Long id,
            String name,
            Date dateOfBirth,
            Genre genre,
            Color color) {
        return new Horse(id, name, dateOfBirth, genre, color);
    }



}
