package umc.study.converter;

import umc.study.domain.Users;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

/*
public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Users member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
*/

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Users member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Users toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3: 
                gender = Gender.NONE;
                break;
        }

        return Users.builder()
                .address(request.getAddress())
                // .specAddress(request.getSpecAddress())
                .gender(gender)
                .username(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}