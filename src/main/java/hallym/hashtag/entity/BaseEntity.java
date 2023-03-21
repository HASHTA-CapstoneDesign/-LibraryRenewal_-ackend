package hallym.hashtag.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})

public class BaseEntity {

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @Column(name = "moddate")
    private LocalDateTime modDate;

    private boolean is_deleted;

}
