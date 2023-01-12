package br.com.jccf.room.web.app;

import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
