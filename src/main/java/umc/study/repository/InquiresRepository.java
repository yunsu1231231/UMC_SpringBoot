package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Inquires;

public interface InquiresRepository extends JpaRepository<Inquires, Long> {
}