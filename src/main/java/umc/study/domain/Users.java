package umc.study.domain;


import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(length = 50, nullable = true) // mysql null 가능하게 일단 설정
    private String email;

    @Column(nullable = false, length = 40) // mysql null 가능하게 일단 설정
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    private LocalDate inactiveDate;

    private String address;

    // @ElementCollection
    // private List<String> memberPreferList;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<User_Preferences> memberPreferList = new ArrayList<>();


    // private String specAddress;

    // @Enumerated(EnumType.STRING)
    // private SocialType socialType;

    // private Integer point;
}