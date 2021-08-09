package com.adincuff.racingstats.horse;

import com.adincuff.racingstats.horse.adapter.in.web.RegisterHorseController;
import com.adincuff.racingstats.horse.application.port.in.RegisterHorseCommand;
import com.adincuff.racingstats.horse.application.port.in.RegisterHorseUseCase;
import com.adincuff.racingstats.horse.domain.Color;
import com.adincuff.racingstats.horse.domain.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@WebMvcTest(controllers = RegisterHorseController.class)
public class RegisterHorseControllerShould {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RegisterHorseUseCase registerHorseUseCase;

    @Test
    void registerAHorseIfCommandIsCorrect() throws Exception {

        // Arrange

        String content = "{\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"jacasse\",\n" +
                "        \"dateOfBirth\": \"2019-02-10\",\n" +
                "        \"genre\": \"GELDING\",\n" +
                "        \"color\": \"GREY\"\n" +
                "    }";

        RegisterHorseCommand horseCommand = new RegisterHorseCommand("jacasse", new Date(2019-02-10), Genre.GELDING, Color.GREY);

        // Act and Assert

        mockMvc.perform(
                post("/api/horses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk());
    }

    @Test
    void sendBackAnExceptionIfCommandIsNotCorrect() throws Exception {

        // Arrange

        String content = "{\n" +
                "        \"id\": 1,\n" +
                "        \"dateOfBirth\": \"2021-02-10\",\n" +
                "        \"genre\": \"GELDING\",\n" +
                "        \"color\": \"GREY\"\n" +
                "    }";

        // Act and Assert

        mockMvc.perform(
                post("/api/horses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isBadRequest());

        then(registerHorseUseCase).shouldHaveNoInteractions();

    }

}
