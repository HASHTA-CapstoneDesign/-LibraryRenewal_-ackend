package hallym.hashtag.domain.ABook.service;

import hallym.hashtag.domain.ABook.repostory.ABookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ABookServicelmpl implements ABookService {
    private final ABookRepository aBookRepository;
}
