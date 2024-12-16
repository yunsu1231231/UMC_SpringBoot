package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umc.study.domain.Missions;


@Repository
public interface MissionRepository extends JpaRepository<Missions, Long> {
    // 특정 가게의 미션 목록을 조회
    Page<Missions> findByStoresId(Long storeId, Pageable pageable);

    // 특정 가게에서 완료되지 않은 미션 조회
    @Query("SELECT m FROM Missions m WHERE m.completed = false AND m.stores.id = :storeId")
    Page<Missions> findOngoingMissionsByStore(@Param("storeId") Long storeId, Pageable pageable);
}



