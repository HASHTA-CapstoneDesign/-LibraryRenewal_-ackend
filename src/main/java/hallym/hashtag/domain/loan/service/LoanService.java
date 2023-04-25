package hallym.hashtag.domain.loan.service;

import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.dto.LoanResponseDto;


public interface LoanService {

    LoanResponseDto create(LoanRequestDto loanRequestDto, Long sno, Long abno);

    LoanResponseDto extension(Long sno,  Long lno);
}
