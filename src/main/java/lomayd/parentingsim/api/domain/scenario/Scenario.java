package lomayd.parentingsim.api.domain.scenario;

import lombok.*;

import javax.persistence.*;

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
    private String illustration;

    @Column
    private String script;

    @Column
    private boolean end;

    @Column
    private int choice_1;

    @Column
    private String choice_1_script;

    @Column
    private int choice_2;

    @Column
    private String choice_2_script;

    @Column
    private int choice_3;

    @Column
    private String choice_3_script;

    @Column
    private int choice_4;

    @Column
    private String choice_4_script;
}
