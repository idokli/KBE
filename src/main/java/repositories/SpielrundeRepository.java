package repositories;

import datenmodel.Spielrunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpielrundeRepository extends JpaRepository<Spielrunde, Long> {
}
