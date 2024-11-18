package umc.study.service.storeService;

import umc.study.domain.Stores;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Stores> findStore(Long id);
    List<Stores> findStoresByNameAndScore(String name, Float score);
}