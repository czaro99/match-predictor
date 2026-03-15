package pl.czaro.match_predictor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.czaro.match_predictor.model.LeagueMember;
import pl.czaro.match_predictor.model.Match;
import pl.czaro.match_predictor.model.Prediction;

import java.util.List;
import java.util.Optional;

public interface PredictionRepository extends JpaRepository<Prediction, Long> {

    Optional<Prediction> findByLeagueMemberAndMatch(LeagueMember member, Match match);

    List<Prediction> findByMatch(Match match);

    List<Prediction> findByLeagueMember(LeagueMember member);
}
