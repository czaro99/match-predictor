package pl.czaro.match_predictor.service;

import org.springframework.stereotype.Service;
import pl.czaro.match_predictor.model.Match;
import pl.czaro.match_predictor.repository.MatchRepository;

import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}