package pl.czaro.match_predictor.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "league_members",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "league_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeagueMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "league_id", nullable = false)
    private League league;

    @OneToMany(mappedBy = "leagueMember", cascade = CascadeType.ALL)
    private List<Prediction> predictions = new ArrayList<>();

    @Column(nullable = false)
    private Integer pointsTotal = 0;

}