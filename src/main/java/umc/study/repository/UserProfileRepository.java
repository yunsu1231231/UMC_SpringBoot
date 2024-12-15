package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Users;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<Users, Long> {
    Optional<Users> findFirstByOrderByUserIdAsc();
}


