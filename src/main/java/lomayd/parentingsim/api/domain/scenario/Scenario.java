package lomayd.parentingsim.api.domain.scenario;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Scenario {

    @Id
    private int id;

    @Column
    private int episode;

    @Column
    private int choice_1;

    @Column
    private int choice_2;

    @Column
    private int illustration;

    @Column
    private String script;

    @Column
    private double score_point;

    @Column
    private double score_patient;

    @Column
    private double score_manner;

    @Column
    private double score_concentration;
}
