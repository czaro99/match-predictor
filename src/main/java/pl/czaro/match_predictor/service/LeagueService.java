package pl.czaro.match_predictor.service;

import org.springframework.stereotype.Service;
import pl.czaro.match_predictor.model.League;
import pl.czaro.match_predictor.repository.LeagueRepository;

import java.util.List;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }
}
