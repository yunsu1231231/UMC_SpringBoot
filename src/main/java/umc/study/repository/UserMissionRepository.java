package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.mapping.User_Missions;

@Repository
public interface UserMissionRepository extends JpaRepository<User_Missions, Long> {
}


