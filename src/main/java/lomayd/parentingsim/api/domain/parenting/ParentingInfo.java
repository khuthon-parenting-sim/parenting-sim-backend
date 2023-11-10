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
public class ParentingInfo {

    @Id
    private int id;

    @Column
    private String title;

    @Column
    private String detail;

    @Column
    private String tag;

    @Column
    private String video_link;
}
