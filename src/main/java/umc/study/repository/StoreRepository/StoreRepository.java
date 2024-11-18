package umc.study.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Stores;

public interface StoreRepository extends JpaRepository<Stores, Long>, StoreRepositoryCustom {
}
