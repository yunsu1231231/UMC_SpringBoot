package study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import study.domain.MISSIONS;
import study.domain.USERS;
import study.domain.common.BaseEntity;
import study.domain.enums.MemberStatus;

import java.security.Timestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class USER_MISSIONS extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long missions_completed;

    private boolean is_points_awarded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private MISSIONS missions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private USERS users;

    @Column(name = "completed_at")
    private Timestamp completedAt;

    @CreationTimestamp
    @Column(name = "started_at", updatable = false)
    private Timestamp startedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_completed", columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGING'")
    private MemberStatus status;

}