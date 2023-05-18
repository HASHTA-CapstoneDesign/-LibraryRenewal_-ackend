package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import hallym.hashtag.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeServicelmpl implements NoticeService{
    private final NoticeRepository noticeRepository;

    @Override
    public List<NoticeResponseDto> findAll() {
        List<Notice> noticeList = noticeRepository.findByAll();
        return noticeList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public NoticeResponseDto findByOne(Long nno) {
        Optional<Notice> byNno = noticeRepository.findById(nno);
        if(byNno.isEmpty()) return null;
        Notice notice = byNno.get();
        return toDto(notice);
    }

    @Override
    public List<NoticeResponseDto> search(String keyword) {
        List<Notice> noticeList = noticeRepository.search(keyword);
        if(noticeList == null) return null;
        else return noticeList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public NoticeResponseDto toDto(Notice notice) {
        return NoticeResponseDto.builder()
                .nno(notice.getNno())
                .title(notice.getTitle())
                .content(notice.getContent())
                .regDate(notice.getRegDate())
                .modDate(notice.getModDate())
                .important(notice.isImportant())
                .writer("관리자").build();
    }
}
