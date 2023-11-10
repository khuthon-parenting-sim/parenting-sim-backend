package lomayd.parentingsim.api.domain.user;

import lomayd.parentingsim.api.domain.scenario.Scenario;
import lomayd.parentingsim.api.domain.scenario.ScenarioResult;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLog {

    @Id
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Scenario scenario;

    @ManyToOne(fetch = FetchType.LAZY)
    private ScenarioResult scenarioResult;

    @Column
    private long timestamp;
}
