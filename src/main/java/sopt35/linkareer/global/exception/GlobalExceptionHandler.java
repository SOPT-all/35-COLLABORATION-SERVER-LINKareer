package sopt35.linkareer.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.api.dto.response.ErrorResponse;

;

/*
전역에서 발생하는 예외를 처리하는 클래스
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // LinkareerException 처리
    @ExceptionHandler(LinkareerException.class)
    public ResponseEntity<ErrorResponse> handleLinkareerException(LinkareerException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getErrorCode(), e.getMessage()));
    }

    // @RequestBody 바인딩 에러 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(ErrorCode.INVALID_INPUT_VALUE, message));
    }

    // 기타 예외 처리 (상태 코드 500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR));
    }
}

