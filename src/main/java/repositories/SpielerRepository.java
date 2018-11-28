package repositories;

import datenmodel.Spieler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpielerRepository  extends JpaRepository<Spieler, Long> {
}
