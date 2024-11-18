package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User_Preferences;

public interface UserPreferencesRepository extends JpaRepository<User_Preferences, Long> {
}



