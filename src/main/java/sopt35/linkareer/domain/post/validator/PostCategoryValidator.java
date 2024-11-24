package sopt35.linkareer.domain.post.validator;

import org.springframework.stereotype.Component;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.global.exception.LinkareerException;

@Component
public class PostCategoryValidator {

    // 카테고리 값을 검증하고 반환
    public void validate(final String category) {
        if (category == null || category.isEmpty()) {
            throw new LinkareerException(ErrorCode.INVALID_INPUT_CATEGORY_VALUE);
        }
    }
}
