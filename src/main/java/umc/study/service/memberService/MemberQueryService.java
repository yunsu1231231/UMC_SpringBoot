package umc.study.service.memberService;

import umc.study.domain.Users;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Users> findMember(Long id);
}
