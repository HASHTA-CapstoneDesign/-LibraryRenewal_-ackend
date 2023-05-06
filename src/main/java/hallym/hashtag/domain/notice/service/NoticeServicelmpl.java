package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.notice.dto.NoticeRequestDto;
import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import hallym.hashtag.domain.user.entity.User;
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
    private final UserRepository userRepository;

    @Override
    public NoticeResponseDto create(Long uno, NoticeRequestDto noticeRequestDto) {
        Optional<User> byUno = userRepository.findById(uno);
        if(byUno.isEmpty()) return null;
        Notice notice = toEntity(noticeRequestDto);
        notice.setUser(byUno.get());
        noticeRepository.save(notice);
        return toDto(notice);
    }

    @Override
    public List<NoticeResponseDto> findAll() {
        List<Notice> noticeList = noticeRepository.findAll();
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
    public NoticeResponseDto update(Long nno, NoticeRequestDto noticeRequestDto) {
        Optional<Notice> byNno = noticeRepository.findById(nno);
        if(byNno.isEmpty()) return null;
        Notice notice = byNno.get();
        notice.update(toEntity(noticeRequestDto));
        noticeRepository.save(notice);
        return toDto(notice);
    }

    @Override
    public String delete(Long nno) {
        Optional<Notice> byNno = noticeRepository.findById(nno);
        if(byNno.isEmpty()) return "ID를 없습니다.";
        noticeRepository.deleteById(nno);
        return "삭제되었습니다.";
    }

    @Override
    public List<NoticeResponseDto> search(String keyword) {
        List<Notice> noticeList = noticeRepository.findByTitleContainingOrContentContaining(keyword, keyword);
        if(noticeList == null) return null;
        else return noticeList.stream().map(this::toDto).collect(Collectors.toList());
    }


    public Notice toEntity(NoticeRequestDto noticeRequestDto) {
        return Notice.builder()
                .nno(noticeRequestDto.getNno())
                .title(noticeRequestDto.getTitle())
                .content(noticeRequestDto.getContent())
                .user(noticeRequestDto.getUser())
                .build();
    }

    public NoticeResponseDto toDto(Notice notice) {
        return NoticeResponseDto.builder()
                .nno(notice.getNno())
                .title(notice.getTitle())
                .content(notice.getContent())
                .regDate(notice.getRegDate())
                .modDate(notice.getModDate())
                .writer("관리자").build();
    }
}
