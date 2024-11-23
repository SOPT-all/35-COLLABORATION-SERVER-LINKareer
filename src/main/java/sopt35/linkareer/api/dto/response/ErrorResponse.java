package sopt35.linkareer.api.dto.response;

/*
에러 응답을 정의한 클래스
 */
public class ErrorResponse {
    private final String message;

    // 기본 메시지 생성
    public ErrorResponse(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    // 커스텀 메시지 생성
    public ErrorResponse(ErrorCode errorCode, String customMessage) {
        this.message = customMessage != null ? customMessage : errorCode.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
