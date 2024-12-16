package umc.study.service.memberService;

import umc.study.domain.Users;
import umc.study.web.dto.MemberRequestDTO;

public class MemberCommandService {
    Users joinMember(MemberRequestDTO.JoinDto request);
}
