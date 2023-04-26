package hallym.hashtag.domain.loan.service;

import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.dto.LoanResponseDto;

import java.util.List;


public interface LoanService {

    LoanResponseDto create(LoanRequestDto loanRequestDto, Long sno, Long abno);

    LoanResponseDto extension(Long sno,  Long lno);

    LoanResponseDto returnBook(Long sno, Long lno);

    List<LoanResponseDto> findAllByStudent(Long sno);

    List<LoanResponseDto> findAllByABook(Long bno);
}
