package br.com.jccf.room.web.app.data;

import br.com.jccf.room.web.app.models.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
