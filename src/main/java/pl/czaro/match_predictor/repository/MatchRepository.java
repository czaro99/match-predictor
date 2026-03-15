package pl.czaro.match_predictor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.czaro.match_predictor.model.Match;
import pl.czaro.match_predictor.model.MatchStatus;

import java.time.OffsetDateTime;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByStatus(MatchStatus status);

    List<Match> findByStartDateAfter(OffsetDateTime date);
}
