package umc.study.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.MemberConverter;
import umc.study.domain.Users;
import umc.study.web.dto.MemberRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Users joinMember(MemberRequestDTO.JoinDto request) {

        Users newMember = MemberConverter.toMember(request);

        newMember.encodePassword(passwordEncoder.encode(request.getPassword()));

        // ... 기존 코드 ...

        return newMember;
    }
}