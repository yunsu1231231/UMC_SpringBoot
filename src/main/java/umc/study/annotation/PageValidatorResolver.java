package umc.study.annotation;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

// HTTP 요청 파라미터를 검증하고 변환하는 역할
@Component
public class PageValidatorResolver implements HandlerMethodArgumentResolver {

    // 해당 파라미터가 @PageValidator 어노테이션을 가지고 있는지 확인
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageValidator.class);
    }

    // @PageValidator 붙은 파라미터의 값을 검증하고 변환
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String pageParam = webRequest.getParameter("page");
        int page = Integer.parseInt(pageParam);

        if (page < 1) {
            throw new IllegalArgumentException("Page number must be greater than 0");
        }

        return page - 1; // 1-based → 0-based
    }
}
