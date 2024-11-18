package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.User_Missions;

public interface UserMissionsRepository extends JpaRepository<User_Missions, Long> {
}


