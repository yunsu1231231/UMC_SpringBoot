package umc.study.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class StoreRequestDTO {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class StoreDTO {
        private String name;  // Store 이름
        private String address;    // Store 주소
        private String region;     // 지역 이름
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class MissionChallengeRequestDto {
        private Long missionId;
        private Long userId;
        private String status;
        // private LocalDateTime startedAt;
    }

    /*
    @Getter
    @Setter
    @NoArgsConstructor
    public static class MissionDto {
        private String name;
        private String description;


    }
    */

}