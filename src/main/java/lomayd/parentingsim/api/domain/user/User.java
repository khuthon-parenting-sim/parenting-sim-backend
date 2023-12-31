package lomayd.parentingsim.api.domain.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @Column
    private double score_total;

    @Column
    private double score_society;

    @Column
    private double score_control;

    @Column
    private double score_recognition;

    @Column
    private double score_concentration;
}
