package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Missions;
import umc.study.domain.Regions;
import umc.study.domain.Stores;
import umc.study.domain.Users;
import umc.study.domain.mapping.User_Missions;
import umc.study.repository.MissionRepository;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.UserMissionRepository;
import umc.study.repository.UserProfileRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.converter.StoreConverter;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;
    private final UserProfileRepository userProfileRepository; // 로그인 없이 임의 유저 조회

    @Override
    @Transactional
    // 특정 지역에 가게 추가하기 API
    public Stores createStore(StoreRequestDTO.StoreDTO request) {

        // Region 객체 조회 또는 생성
        Regions region = regionRepository.findByRegionName(request.getRegion())
                .orElse(Regions.builder().regionName(request.getRegion()).build());

        // 먼저 Regions 객체를 저장 (저장되지 않은 상태일 경우)
        if (region.getId() == null) {  // Regions 객체가 새로 생성되었을 경우
            region = regionRepository.save(region); // 먼저 저장
        }

        // Stores 객체 생성
        Stores store = StoreConverter.toStore(request, region);

        // Stores 저장 및 반환
        return storeRepository.save(store);
    }

    /*
    // 가게에 미션 추가하기 API
    @Override
    @Transactional
    public Missions createMission(Long storeId, StoreRequestDTO.MissionDTO request) {

        Missions mission = StoreConverter.toMission(request);

        mission.setStore(storeRepository.findById(storeId).get());

        return missionRepository.save(mission);
    }
    */



    // 가게의 미션을 도전 중인 미션에 추가하기 API
    @Override
    @Transactional
    public User_Missions challengeMission(StoreRequestDTO.MissionChallengeRequestDto requestDto) {

        // 1. 임의의 회원 정보 조회 (하드코딩)
        Users user = userProfileRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("No user found in the database"));

        // 2. 미션 정보 조회
        System.out.println("Request Mission ID: " + requestDto.getMissionId());  // 미션 ID 출력
        Missions mission = missionRepository.findById(requestDto.getMissionId())
                .orElseThrow(() -> {
                    System.out.println("Mission with ID " + requestDto.getMissionId() + " not found!");  // 미션이 없을 때 출력
                    return new IllegalArgumentException("Mission not found");
                });
        System.out.println("Mission Found: " + mission);  // 미션 조회 결과 출력

        /*
        // 2. 미션 정보 조회
        Missions mission = missionRepository.findById(requestDto.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        */

        // 3. User_Missions 객체 생성
        User_Missions userMission = StoreConverter.toUserMission(user, mission, requestDto);

        // 4. User_Missions 저장
        return userMissionRepository.save(userMission);
    }
}

