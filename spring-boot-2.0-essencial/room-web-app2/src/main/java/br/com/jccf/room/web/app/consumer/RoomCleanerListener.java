package br.com.jccf.room.web.app.consumer;

import br.com.jccf.room.web.app.models.AsyncPayload;
import br.com.jccf.room.web.app.models.RoomEntity;
import br.com.jccf.room.web.app.services.RoomDatabaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoomCleanerListener {
    private static final Logger LOG = LoggerFactory.getLogger(RoomCleanerListener.class);

    private final ObjectMapper mapper;
    private final RoomDatabaseService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomDatabaseService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    public void receivedMessage(String message) {
        try {
            AsyncPayload payload = mapper.readValue(message, AsyncPayload.class);
            if ("ROOM".equals(payload.getModel())) {
                RoomEntity room = roomService.getById(payload.getId());
                LOG.info("ROOM {}:{} needs to be cleaned", room.getNumber(), room.getName());
            } else {
                LOG.warn("Unknown model type");
            }
        } catch (JsonProcessingException e) {
            LOG.error("Error on processing message", e);
        }
    }
}
