package hallym.hashtag.domain.notice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.admin.entity.Admin;
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ano")
    private Admin admin;

    public void update(Notice notice) {
        this.title = notice.title;
        this.content = notice.content;
    }
}
