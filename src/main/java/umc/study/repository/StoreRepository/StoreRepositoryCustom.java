package umc.study.repository.StoreRepository;
import umc.study.domain.Stores;
import java.util.List;

public interface StoreRepositoryCustom {
    List<Stores> dynamicQueryWithBooleanBuilder(String name, Float score);
}
