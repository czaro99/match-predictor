package pl.czaro.match_predictor.service;

import org.springframework.stereotype.Service;
import pl.czaro.match_predictor.model.LeagueMember;
import pl.czaro.match_predictor.repository.LeagueMemberRepository;

import java.util.List;

@Service
public class LeagueMemberService {

    private final LeagueMemberRepository leagueMemberRepository;

    public LeagueMemberService(LeagueMemberRepository leagueMemberRepository) {
        this.leagueMemberRepository = leagueMemberRepository;
    }

    public List<LeagueMember> getAllLeagueMembers() {
        return leagueMemberRepository.findAll();
    }
}
