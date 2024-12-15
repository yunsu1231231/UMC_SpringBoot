package umc.study.service.memberService;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Users;
import umc.study.repository.UserProfileRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final UserProfileRepository memberRepository;

    @Override
    public Optional<Users> findMember(Long id) {
        return memberRepository.findById(id);
    }
}