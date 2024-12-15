package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Stores;
import umc.study.domain.mapping.User_Missions;
import umc.study.service.MissionService.MissionService;
import umc.study.web.dto.StoreRequestDTO;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    // 특정 지역에 가게 추가하기 API
    @PostMapping("/stores")
    public ResponseEntity<Stores> createStore(@RequestBody StoreRequestDTO.StoreDTO storeDTO) {
        Stores createdStore = missionService.createStore(storeDTO);
        return ResponseEntity.ok(createdStore);
    }

    /*
    // 가게에 미션 추가하기 API
    @PostMapping("/stores/{storeId}/missions")
    public ResponseEntity<Missions> createMission(@PathVariable Long storeId,
                                                  @RequestBody StoreRequestDTO.MissionDTO missionDTO) {
        Missions createdMission = missionService.createMission(storeId, missionDTO);
        return ResponseEntity.ok(createdMission);
    }
    */

    // 가게의 미션을 도전 중인 미션에 추가하기 API
    @PostMapping("/missions/challenge")
    public ResponseEntity<User_Missions> challengeMission(@RequestBody StoreRequestDTO.MissionChallengeRequestDto requestDto) {
        User_Missions challengedMission = missionService.challengeMission(requestDto);
        return ResponseEntity.ok(challengedMission);
    }
}
