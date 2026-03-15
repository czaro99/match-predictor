package pl.czaro.match_predictor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czaro.match_predictor.model.LeagueMember;
import pl.czaro.match_predictor.service.LeagueMemberService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/league-members")
public class LeagueMemberController {

    private final LeagueMemberService leagueMemberService;

    public LeagueMemberController(LeagueMemberService leagueMemberService) {
        this.leagueMemberService = leagueMemberService;
    }

    @GetMapping
    public List<LeagueMember> getAllLeagueMembers() {
        return leagueMemberService.getAllLeagueMembers();
    }
}