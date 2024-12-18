package umc.study.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.converter.MemberConverter;
import umc.study.converter.MemberPreferConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.User_Preferences;
import umc.study.domain.Users;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.UserProfileRepository;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.apiPayload.code.status.ErrorStatus;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final UserProfileRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Users joinMember(MemberRequestDTO.JoinDto request) {

        Users newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {

                    return foodCategoryRepository.findById(category).orElseThrow(() -> {
                        System.out.println("음식 카테고리 not found: " + category);
                        return new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND);
                    });

                    /*
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

                     */
                }).collect(Collectors.toList());

        List<User_Preferences> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}