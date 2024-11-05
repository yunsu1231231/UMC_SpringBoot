package study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import study.domain.REGIONS;
import study.domain.USERS;
import study.domain.common.BaseEntity;
import study.domain.enums.MemberStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class USER_REGION_MISSIONS extends BaseEntity {

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
    private REGIONS regions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private USERS users;
}