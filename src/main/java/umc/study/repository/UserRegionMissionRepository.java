package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.User_Region_Missions;

public interface UserRegionMissionRepository extends JpaRepository<User_Region_Missions, Long> {
}




