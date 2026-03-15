package pl.czaro.match_predictor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.czaro.match_predictor.model.League;
import pl.czaro.match_predictor.model.User;

import java.util.List;

public interface LeagueRepository extends JpaRepository<League, Long> {

    List<League> findByOwner(User owner);

    List<League> findByNameContainingIgnoreCase(String name);
}
