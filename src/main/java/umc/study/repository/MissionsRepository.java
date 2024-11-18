package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Missions;

public interface MissionsRepository extends JpaRepository<Missions, Long> {
}



