package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Missions;
import umc.study.web.dto.MissionResponseDTO;

@Component
public class MissionConverter {
    // Missions 엔티티를 MissionResponseDTO 변환
    public MissionResponseDTO toResponse(Missions mission) {
        return MissionResponseDTO.builder()
                .id(mission.getId())
                .description(mission.getMission_description())
                .pointsAwarded(mission.getPoints_awarded())
                .completed(mission.isCompleted())
                .storeId(mission.getStores().getId())
                .build();
    }
}