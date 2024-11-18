package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Regions;
import umc.study.domain.Users;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MemberStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User_Region_Missions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_points_awarded", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isPointsAwarded;

    @Enumerated(EnumType.STRING)
    @Column(name = "missions_completed", columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGING'")
    private MemberStatus status;

    // 둘 다 단방향 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Regions regions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
}