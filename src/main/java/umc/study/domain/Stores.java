package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Stores extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Regions region;

    @OneToMany(mappedBy = "stores", cascade = CascadeType.ALL)
    private List<Missions> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "stores", cascade = CascadeType.ALL)
    private List<Reviews> reviewList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getRegionName() : "N/A") + // region의 이름 출력
                '}';
    }
}

