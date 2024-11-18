package umc.study.service.memberService;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Users;
import umc.study.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final UsersRepository memberRepository;

    @Override
    public Optional<Users> findMember(Long id) {
        return memberRepository.findById(id);
    }
}