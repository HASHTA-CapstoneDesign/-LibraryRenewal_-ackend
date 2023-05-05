package hallym.hashtag.domain.user.repository;

import hallym.hashtag.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByNumber(String username);
}
