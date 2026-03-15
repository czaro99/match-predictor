package pl.czaro.match_predictor.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.czaro.match_predictor.model.*;
import pl.czaro.match_predictor.repository.*;

import java.time.OffsetDateTime;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final LeagueRepository leagueRepository;
    private final LeagueMemberRepository leagueMemberRepository;
    private final MatchRepository matchRepository;
    private final PredictionRepository predictionRepository;

    public SampleDataLoader(UserRepository userRepository,
                            LeagueRepository leagueRepository,
                            LeagueMemberRepository leagueMemberRepository,
                            MatchRepository matchRepository,
                            PredictionRepository predictionRepository) {
        this.userRepository = userRepository;
        this.leagueRepository = leagueRepository;
        this.leagueMemberRepository = leagueMemberRepository;
        this.matchRepository = matchRepository;
        this.predictionRepository = predictionRepository;
    }

    @Override
    public void run(String... args) {
        // --- USERS ---
        User user1 = new User();
        user1.setUsername("czaro");
        user1.setEmail("czaro@example.com");
        user1.setPassword("secret");
        user1.setUserType(UserType.USER);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setEmail("admin@example.com");
        user2.setPassword("admin");
        user2.setUserType(UserType.ADMIN);

        userRepository.save(user1);
        userRepository.save(user2);

        // --- LEAGUE ---
        League league1 = new League();
        league1.setName("Super Liga");
        league1.setOwner(user1);

        leagueRepository.save(league1);

        // --- LEAGUE MEMBERS ---
        LeagueMember member1 = new LeagueMember();
        member1.setUser(user1);
        member1.setLeague(league1);
        member1.setPointsTotal(0);

        LeagueMember member2 = new LeagueMember();
        member2.setUser(user2);
        member2.setLeague(league1);
        member2.setPointsTotal(0);

        leagueMemberRepository.save(member1);
        leagueMemberRepository.save(member2);

        // --- MATCHES ---
        Match match1 = new Match();
        match1.setHomeTeamName("Team A");
        match1.setAwayTeamName("Team B");
        match1.setStartDate(OffsetDateTime.now().plusDays(1));
        match1.setStatus(MatchStatus.SCHEDULED);

        Match match2 = new Match();
        match2.setHomeTeamName("Team C");
        match2.setAwayTeamName("Team D");
        match2.setStartDate(OffsetDateTime.now().plusDays(2));
        match2.setStatus(MatchStatus.SCHEDULED);

        matchRepository.save(match1);
        matchRepository.save(match2);

        // --- OPTIONAL: sample predictions ---
        Prediction pred1 = new Prediction();
        pred1.setLeagueMember(member1);
        pred1.setMatch(match1);
        pred1.setPredictedHomeScore(2);
        pred1.setPredictedAwayScore(1);

        Prediction pred2 = new Prediction();
        pred2.setLeagueMember(member2);
        pred2.setMatch(match2);
        pred2.setPredictedHomeScore(0);
        pred2.setPredictedAwayScore(3);

        predictionRepository.save(pred1);
        predictionRepository.save(pred2);
    }
}