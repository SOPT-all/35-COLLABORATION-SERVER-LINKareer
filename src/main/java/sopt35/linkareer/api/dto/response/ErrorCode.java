package sopt35.linkareer.api.dto.response;

public enum ErrorCode {
    INVALID_INPUT_VALUE("유효하지 않은 요청입니다."),
    INVALID_INPUT_CATEGORY_VALUE("카테고리는 필수 항목입니다."),
    INVALID_INPUT_OFFICIAL_VALUE("잘못된 공고 리스트 요청입니다."),
    CATEGORY_NOT_FOUND("존재하지 않는 카테고리입니다."),
    INTERNAL_SERVER_ERROR("서버 내부 오류입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
}