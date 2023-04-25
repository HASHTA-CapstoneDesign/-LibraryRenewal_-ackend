package hallym.hashtag.domain.loan.service;

import hallym.hashtag.domain.ABook.entity.ABook;
import hallym.hashtag.domain.ABook.repostory.ABookRepository;
import hallym.hashtag.domain.loan.dto.LoanRequestDto;
import hallym.hashtag.domain.loan.dto.LoanResponseDto;
import hallym.hashtag.domain.loan.entity.Loan;
import hallym.hashtag.domain.loan.repostory.LoanRepository;
import hallym.hashtag.domain.student.entity.Student;
import hallym.hashtag.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class LoanServicelmpl implements LoanService {
    private final ABookRepository aBookRepository;
    private final StudentRepository studentRepository;
    private final LoanRepository loanRepository;
    @Override
    public LoanResponseDto create(LoanRequestDto loanRequestDto, Long sno, Long abno) {
        Optional<ABook> byAbno = aBookRepository.findById(abno);
        Optional<Student> bySno = studentRepository.findById(sno);
        loanRequestDto.setABook(byAbno.get());
        loanRequestDto.setStudent(bySno.get());

        LocalDate creDate = LocalDate.now();
        LocalDate retDate = creDate.plusDays(7);
        loanRequestDto.setRetDate(retDate);

        Loan newLoan = toEntity(loanRequestDto);
        loanRepository.save(newLoan);
        return toDto(newLoan);
    }

    Loan toEntity(LoanRequestDto loanRequestDto){
        return Loan.builder()
                .lno(loanRequestDto.getLno())
                .creDate(loanRequestDto.getCreDate())
                .retDate(loanRequestDto.getRetDate())
                .aBook(loanRequestDto.getABook())
                .student(loanRequestDto.getStudent())
                .build();
    }

    LoanResponseDto toDto(Loan loan){
        return LoanResponseDto.builder()
                .lno(loan.getLno())
                .creDate(loan.getCreDate())
                .retDate(loan.getRetDate())
                .build();
    }


}
