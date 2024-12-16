package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionResponseDTO {
    private Long id;
    private String description;
    private Long pointsAwarded;
    private boolean completed;
    private Long storeId;
}
