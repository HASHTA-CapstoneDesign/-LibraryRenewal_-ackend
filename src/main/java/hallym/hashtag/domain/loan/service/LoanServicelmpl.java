package hallym.hashtag.domain.loan.service;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.abook.repostory.ABookRepository;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        if(byAbno.isEmpty()) return null;
        if(bySno.isEmpty()) return null;

        loanRequestDto.setABook(byAbno.get());
        loanRequestDto.setStudent(bySno.get());

        LocalDate creDate = LocalDate.now();
        LocalDate retDate = creDate.plusDays(7);
        loanRequestDto.setRetDate(retDate);

        Loan newLoan = toEntity(loanRequestDto);

        ABook aBook = byAbno.get();

        aBook.setLoanType(Boolean.TRUE);

        aBookRepository.save(aBook);
        loanRepository.save(newLoan);
        return toDto(newLoan);
    }

    @Override
    public LoanResponseDto extension(Long sno, Long lno) {
        Optional<Student> bySno = studentRepository.findById(sno);
        Optional<Loan> byLno = loanRepository.findById(lno);

        if(bySno.isEmpty()) return null;
        if(byLno.isEmpty()) return null;

        LocalDate Date = byLno.get().getRetDate();
        LocalDate retDate = Date.plusDays(7);

        Loan updateLoan = byLno.get();

        updateLoan.setRetDate(retDate);

        loanRepository.save(updateLoan);
        return toDto(updateLoan);
    }

    @Override
    public LoanResponseDto returnBook(Long sno, Long lno) {
        Optional<Student> bySno = studentRepository.findById(sno);
        Optional<Loan> byLno = loanRepository.findById(lno);

        if(bySno.isEmpty()) return null;
        if(byLno.isEmpty()) return null;

        LocalDate nowDate = LocalDate.now();

        Loan updateLoan = byLno.get();

        updateLoan.setNowRetDate(nowDate);

        Optional<ABook> byAbno = aBookRepository.findById(byLno.get().getABook().getAbno());

        ABook aBook = byAbno.get();

        aBook.setLoanType(Boolean.FALSE);

        aBookRepository.save(aBook);
        loanRepository.save(updateLoan);
        return toDto(updateLoan);
    }

    @Override
    public List<LoanResponseDto> findAllByStudent(Long sno) {
        Optional<Student> bySno = studentRepository.findById(sno);
        if(bySno.isEmpty()) return null;

        List<Loan> loanList = loanRepository.findByStudent_sno(sno);
        return getLoanList(loanList);
    }

    @Override
    public List<LoanResponseDto> findAllByABook(Long abno) {
        Optional<ABook> byAbno = aBookRepository.findById(abno);
        if(byAbno.isEmpty()) return null;

        List<Loan> findLaon = loanRepository.findByABook_abno(abno);

        return getLoanList(findLaon);
    }


    Loan toEntity(LoanRequestDto loanRequestDto){
        return Loan.builder()
                .lno(loanRequestDto.getLno())
                .creDate(loanRequestDto.getCreDate())
                .retDate(loanRequestDto.getRetDate())
                .nowRetDate(loanRequestDto.getNowRetDate())
                .aBook(loanRequestDto.getABook())
                .student(loanRequestDto.getStudent())
                .build();
    }

    LoanResponseDto toDto(Loan loan){
        return LoanResponseDto.builder()
                .lno(loan.getLno())
                .creDate(loan.getCreDate())
                .retDate(loan.getRetDate())
                .nowRetDate(loan.getNowRetDate())
                .build();
    }

    public List<LoanResponseDto> getLoanList(List<Loan> all) {
        return all.stream().map(loan -> toDto(loan)).collect(Collectors.toList());
    }


}
