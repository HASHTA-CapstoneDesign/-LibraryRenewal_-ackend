package hallym.hashtag.domain.notice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.global.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonManagedReference
    @OneToOne(mappedBy = "notice", fetch = FetchType.LAZY)
    private NoticeImage image;

    private String imageFileName;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uno")
    private User user;
}
