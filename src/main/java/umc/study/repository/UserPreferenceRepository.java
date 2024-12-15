package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User_Preferences;

public interface UserPreferenceRepository extends JpaRepository<User_Preferences, Long> {
}



