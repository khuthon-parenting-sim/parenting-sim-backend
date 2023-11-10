package lomayd.parentingsim.api.domain.parenting;

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
public class ParentingSituation {

    @Id
    private int id;

    @Column
    private String title;

    @Column
    private String detail;

    @Column
    private String good_example_detail;

    @Column
    private String good_example_video_link;

    @Column
    private String bad_example_detail;

    @Column
    private String bad_example_video_link;
}
