package hallym.hashtag.domain.ABook.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hallym.hashtag.domain.book.entity.Book;
import hallym.hashtag.global.baseEntity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "abook")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ABook extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long abno;

    private String tag;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bno")
    private Book book;
}
