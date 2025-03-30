package umc.study.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Reviews;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    // 특정 사용자가 작성한 리뷰 목록을 조회
    Page<Reviews> findByUsersId(Long userId, Pageable pageable);
}


