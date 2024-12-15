package umc.study.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Regions;

import java.util.Optional;

// JpaRepository 상속
// JpaRepository<T, ID> = T: 관리할 엔티티 클래스의 타입 (Region), ID: 엔티티의 ID(기본 키)의 타입 (Long)

@Repository
public interface RegionRepository extends JpaRepository<Regions, Long> {
    // Regions 엔티티의 name 속성을 기준으로 데이터를 조회, 이름이 name 일치하는 행 반환
    Optional<Regions> findByName(String name);
}




