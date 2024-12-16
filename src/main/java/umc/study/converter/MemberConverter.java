package umc.study.converter;

import umc.study.domain.Users;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequestDTO;

import java.util.ArrayList;

public class MemberConverter {
    public static Users toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;
        switch (request.getGender()) {
            case 1: gender = Gender.MALE; break;
            case 2: gender = Gender.FEMALE; break;
            case 3: gender = Gender.NONE; break;
        }

        return Users.builder()
                .username(request.getName())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .gender(gender)
                .address(request.getAddress())
                // .specAddress(request.getSpecAddress())
                .role(request.getRole())   // 추가된 코드
                // .status(new ArrayList<MemberStatus>())
                .build();
    }
}