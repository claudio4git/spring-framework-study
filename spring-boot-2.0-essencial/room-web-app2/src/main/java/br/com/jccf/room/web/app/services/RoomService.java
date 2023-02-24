package br.com.jccf.room.web.app.services;

import br.com.jccf.room.web.app.models.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class RoomService {

    private static final List<Room> rooms = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i, "Room " + i, "R" + i, "Q"));
        }
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
}
