package lomayd.parentingsim.api.domain.scenario;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScenarioResult {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Scenario scenario;

    @Column
    private String script;

    @Column
    private double score_society;

    @Column
    private double score_control;

    @Column
    private double score_recognition;

    @Column
    private double score_concentration;
}
