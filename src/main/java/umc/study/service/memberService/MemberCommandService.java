package umc.study.service.memberService;

import umc.study.domain.Users;
import umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Users joinMember(MemberRequestDTO.JoinDto request);
}
