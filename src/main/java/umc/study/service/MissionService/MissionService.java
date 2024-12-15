package umc.study.service.MissionService;

import umc.study.domain.Stores;
import umc.study.domain.mapping.User_Missions;
import umc.study.web.dto.StoreRequestDTO;

public interface MissionService {
    Stores createStore(StoreRequestDTO.StoreDTO request);
    User_Missions challengeMission(StoreRequestDTO.MissionChallengeRequestDto requestDto);
    /* Missions createMission(Long storeId, StoreRequestDTO.MissionDTO request); */
}
