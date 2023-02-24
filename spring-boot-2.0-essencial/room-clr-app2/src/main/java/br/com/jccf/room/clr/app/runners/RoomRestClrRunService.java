package br.com.jccf.room.clr.app.runners;

import br.com.jccf.room.clr.app.dtos.Room;
import br.com.jccf.room.clr.app.RoomClrApp2Application;
import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.web.client.*;
import org.springframework.context.annotation.*;
import org.springframework.core.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;

@Service
public class RoomRestClrRunService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomClrApp2Application.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            LOGGER.info("Starting CLR application");

            ResponseEntity<List<Room>> rooms = restTemplate.exchange(
                    "http://localhost:8080/api/rooms",
                    HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

            Objects.requireNonNull(rooms.getBody())
                    .forEach(room -> LOGGER.info(room.toString()));

            LOGGER.info("Finishing CLR application");
        };
    }
}
