package br.com.jccf.room.web.app.data;

import br.com.jccf.room.web.app.models.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "/api/rest", path = "rooms")
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
