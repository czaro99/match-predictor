package pl.czaro.match_predictor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "predictions",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"league_member_id", "match_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "league_member_id", nullable = false)
    private LeagueMember leagueMember;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    private Integer predictedHomeScore;
    private Integer predictedAwayScore;

    private Integer pointsAwarded;

}