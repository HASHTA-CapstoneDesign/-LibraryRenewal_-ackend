package hallym.hashtag.domain.loan.repostory;

import hallym.hashtag.domain.abook.entity.ABook;
import hallym.hashtag.domain.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("select l from Loan l where l.user.uno=:uno order by l.lno desc")
    List<Loan> findByUser_uno(@Param("uno") Long uno);

}
