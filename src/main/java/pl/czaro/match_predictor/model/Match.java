package pl.czaro.match_predictor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String homeTeamName;

    @Column(nullable = false)
    private String awayTeamName;

    @Column(nullable = false)
    private OffsetDateTime startDate;

    private Integer homeTeamScore;
    private Integer awayTeamScore;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MatchStatus status = MatchStatus.SCHEDULED;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<Prediction> predictions = new ArrayList<>();

}
