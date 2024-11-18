package umc.study.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.study.apiPayload.code.BaseCode;
import umc.study.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    // 일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다."),
    CREATED(HttpStatus.CREATED, "COMMON201", "리소스가 성공적으로 생성되었습니다."),

    // 회원 관련 응답
    SIGNUP_SUCCESS(HttpStatus.CREATED, "MEMBER201", "회원가입이 성공적으로 완료되었습니다."),
    LOGIN_SUCCESS(HttpStatus.OK, "MEMBER2001", "로그인이 성공적으로 완료되었습니다."),

    // 홈 화면 관련 응답
    HOME_DATA_FETCHED(HttpStatus.OK, "HOME2001", "홈 화면 데이터가 성공적으로 조회되었습니다."),

    // 리뷰 관련 응답
    REVIEW_CREATED(HttpStatus.CREATED, "REVIEW201", "리뷰가 성공적으로 작성되었습니다."),
    REVIEW_DELETED(HttpStatus.OK, "REVIEW2001", "리뷰가 성공적으로 삭제되었습니다."),
    REVIEW_UPDATED(HttpStatus.OK, "REVIEW2002", "리뷰가 성공적으로 수정되었습니다."),

    // 미션 관련 응답
    MISSION_FETCHED(HttpStatus.OK, "MISSION2001", "미션 목록이 성공적으로 조회되었습니다."),
    MISSION_COMPLETED(HttpStatus.OK, "MISSION2002", "미션이 성공적으로 완료되었습니다."),

    // 기타 응답
    REGION_DATA_FETCHED(HttpStatus.OK, "REGION2001", "지역 데이터가 성공적으로 조회되었습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
