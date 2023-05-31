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

@EqualsAndHashCode(callSuper = true)
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

    @Column(length=1000)
    private String content;

    private boolean important;

    private String image;

    @Builder.Default
    @JsonManagedReference
    @OneToMany(mappedBy = "notice", fetch = FetchType.LAZY)
    private List<NoticeImage> images = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uno")
    private User user;
}
