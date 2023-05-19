package hallym.hashtag.domain.notice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.global.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "notice")
@AllArgsConstructor
@NoArgsConstructor
public class Notice extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nno;

    private String title;

    private String content;

    private boolean important;

    @Embedded
    private NoticeImage image;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uno")
    private User user;

    public void update(Notice notice) {
        this.title = notice.title;
        this.content = notice.content;
    }
}
