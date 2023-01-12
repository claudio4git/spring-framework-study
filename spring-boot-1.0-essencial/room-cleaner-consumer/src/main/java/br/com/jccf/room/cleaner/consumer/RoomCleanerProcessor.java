package br.com.jccf.room.cleaner.consumer;

import com.fasterxml.jackson.databind.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import java.io.*;

@Component
public class RoomCleanerProcessor {
    private final ObjectMapper objectMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomCleanerProcessor.class);

    public RoomCleanerProcessor() {
        this.objectMapper = new ObjectMapper();
    }

    public void receiveMessage(String roomJson) {
        LOGGER.info("Message received");
        try {
            Room room = objectMapper.readValue(roomJson, Room.class);
            LOGGER.info("Room ready for cleaning " + room.getNumber());
        } catch (IOException exception) {
            LOGGER.error("Error performing message", exception);
        }
    }
}
