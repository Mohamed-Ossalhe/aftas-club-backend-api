package ma.youcode.aftasclubbackendapi.repositories;

import ma.youcode.aftasclubbackendapi.entities.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuntingRepository extends JpaRepository<Hunting, Long> {
}
