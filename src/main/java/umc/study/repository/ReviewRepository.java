package umc.study.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Reviews;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Long> {
}


