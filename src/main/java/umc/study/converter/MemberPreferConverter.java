package umc.study.converter;

import umc.study.domain.FoodCategory;
import umc.study.domain.User_Preferences;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<User_Preferences> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        User_Preferences.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
