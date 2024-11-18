package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
}


