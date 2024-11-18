package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Notifications;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
}
