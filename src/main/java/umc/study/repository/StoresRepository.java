package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Stores;

public interface StoresRepository extends JpaRepository<Stores, Long> {
}


