package br.com.jccf.room.clr.app;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.slf4j.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.util.*;

@Component
public class RoomCleaningPrimer implements CommandLineRunner {
    @Value("${amqp.queue.name}")
    private String queueName;
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomCleaningPrimer.class);

    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;
    private final ConfigurableApplicationContext context;
    private final ObjectMapper objectMapper;

    @Autowired
    public RoomCleaningPrimer(RabbitTemplate rabbitTemplate, ConfigurableApplicationContext context) {
        this.restTemplate = new RestTemplate();
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void run(String... args) {
        String url = "http://localhost:8080/api/rooms";
        Room[] roomArray = this.restTemplate.getForObject(url, Room[].class);
        assert roomArray != null;
        List<Room> rooms = Arrays.asList(roomArray);
        rooms.forEach(room -> {
            LOGGER.info("Sending message");
            try {
                String jsonString = objectMapper.writeValueAsString(room);
                rabbitTemplate.convertAndSend(queueName, jsonString);
            } catch (JsonProcessingException exception) {
                LOGGER.error("Error performing send", exception);
            }
        });

        context.close();
    }
}
