package hallym.hashtag.domain.notice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Builder
public class NoticeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nino;

    @Column(nullable = false)
    private String fileName;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nno")
    private Notice notice;

    public void setNotice(Notice notice) {
        this.notice = notice;
    }
}
