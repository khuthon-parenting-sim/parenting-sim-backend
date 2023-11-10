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
    private double score_point;

    @Column
    private double score_patient;

    @Column
    private double score_manner;

    @Column
    private double score_concentration;
}
