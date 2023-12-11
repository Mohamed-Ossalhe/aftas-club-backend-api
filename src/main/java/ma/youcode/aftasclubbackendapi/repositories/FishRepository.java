package ma.youcode.aftasclubbackendapi.repositories;

import ma.youcode.aftasclubbackendapi.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Long> {
}
