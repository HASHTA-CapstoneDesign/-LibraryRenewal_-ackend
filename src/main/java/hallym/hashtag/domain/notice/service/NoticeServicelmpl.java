package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.book.dto.BookDto;
import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import hallym.hashtag.domain.user.repository.UserRepository;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PageResponseDto<NoticeResponseDto> findAll(PageRequestDto pageRequestDto) {
        Pageable pageable = PageRequest.of(pageRequestDto.getPage() <=0? 0:
                        pageRequestDto.getPage()-1,
                pageRequestDto.getSize());

        Page<Notice> noticeList = noticeRepository.findByAll(pageable);

        List<NoticeResponseDto> dtoList = noticeList.stream().map(this::toDto).collect(Collectors.toList());

        return PageResponseDto.<NoticeResponseDto>withAll()
                .pageRequestDto(pageRequestDto)
                .dtoList(dtoList)
                .total((int)noticeList.getTotalElements())
                .build();
    }

    @Override
    public PageResponseDto<NoticeResponseDto> search(String keyword, PageRequestDto pageRequestDto) {
        Pageable pageable = PageRequest.of(pageRequestDto.getPage() <=0? 0:
                        pageRequestDto.getPage()-1,
                pageRequestDto.getSize());

        Page<Notice> noticeList = noticeRepository.search(keyword, pageable);

        if(noticeList == null) return null;

        else {
            List<NoticeResponseDto> dtoList = noticeList.stream().map(this::toDto).collect(Collectors.toList());

            return PageResponseDto.<NoticeResponseDto>withAll()
                    .pageRequestDto(pageRequestDto)
                    .dtoList(dtoList)
                    .total((int)noticeList.getTotalElements())
                    .build();
        }
    }

    @Override
    public List<NoticeResponseDto> findByImportant() {
        List<Notice> noticeList = noticeRepository.findAllByImportant(Boolean.TRUE);
        return noticeList.stream().map(this::toDto).collect(Collectors.toList());
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
