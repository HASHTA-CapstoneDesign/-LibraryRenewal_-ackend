package hallym.hashtag.domain.loan.service;

import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.dto.LoanResponseDto;

import java.util.List;


public interface LoanService {

    LoanResponseDto create(Long uno, Long abno);

    LoanResponseDto extension(Long lno);

    LoanResponseDto returnBook(Long lno);

    List<LoanResponseDto> findAllByUser(Long uno);
}
