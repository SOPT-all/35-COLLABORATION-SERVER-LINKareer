package sopt35.linkareer.global.exception;

import sopt35.linkareer.api.dto.response.ErrorCode;

public class LinkareerException extends RuntimeException {
    private final ErrorCode errorCode;

    // ErrorCode의 기본 메시지를 사용하는 생성자
    public LinkareerException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
