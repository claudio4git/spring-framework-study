package br.com.jccf.room.web.app.controllers;

import br.com.jccf.room.web.app.models.RoomEntity;
import br.com.jccf.room.web.app.services.RoomDatabaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data/rooms")
public class RoomDatabaseRestController {
    private final RoomDatabaseService roomService;

    public RoomDatabaseRestController(RoomDatabaseService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomEntity> getAllRooms() {
        return roomService.getAllRooms();
    }
}
