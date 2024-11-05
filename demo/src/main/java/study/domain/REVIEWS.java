package study.domain;

import jakarta.persistence.*;
import lombok.*;
import study.domain.common.BaseEntity;
import study.domain.enums.Gender;
import study.domain.enums.RATING;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class REVIEWS extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String photo_url;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private RATING rating;

    @Column(nullable = false, length = 40)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private USERS users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private STORES stores;
}
