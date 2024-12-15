package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.Missions;

@Repository
public interface MissionRepository extends JpaRepository<Missions, Long> {
}



