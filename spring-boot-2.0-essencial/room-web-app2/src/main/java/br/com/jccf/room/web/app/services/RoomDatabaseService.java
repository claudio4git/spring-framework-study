package br.com.jccf.room.web.app.services;

import br.com.jccf.room.web.app.data.RoomRepository;
import br.com.jccf.room.web.app.models.Room;
import br.com.jccf.room.web.app.models.RoomEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomDatabaseService {

    private RoomRepository repository;

    public RoomDatabaseService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<RoomEntity> getAllRooms() {
        return repository.findAll();
    }

    public RoomEntity getById(long id) {
        return repository.findById(id).orElse(new RoomEntity());
    }
}
