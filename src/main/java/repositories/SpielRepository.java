package repositories;

import datenmodel.Spiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpielRepository extends JpaRepository<Spiel, Long> {
}
