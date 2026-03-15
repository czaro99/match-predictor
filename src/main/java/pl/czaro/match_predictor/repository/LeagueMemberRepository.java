package pl.czaro.match_predictor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.czaro.match_predictor.model.League;
import pl.czaro.match_predictor.model.LeagueMember;
import pl.czaro.match_predictor.model.User;

import java.util.List;
import java.util.Optional;

public interface LeagueMemberRepository extends JpaRepository<LeagueMember, Long> {

    List<LeagueMember> findByLeague(League league);

    Optional<LeagueMember> findByUserAndLeague(User user, League league);
}
