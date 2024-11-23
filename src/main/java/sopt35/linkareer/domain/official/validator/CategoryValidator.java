package sopt35.linkareer.domain.official.validator;

import org.springframework.stereotype.Component;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.domain.official.infra.Category;
import sopt35.linkareer.global.exception.LinkareerException;

@Component
public class CategoryValidator {

    // 카테고리 값을 검증하고 변환
    public Category validate(String category) {
        if (category == null || category.isEmpty()) {
            throw new LinkareerException(ErrorCode.INVALID_INPUT_CATEGORY_VALUE);
        }
        return toCategory(category);
    }

    // 카테고리 값을 Enum으로 변환
    private Category toCategory(String category) {
        try {
            return Category.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new LinkareerException(ErrorCode.CATEGORY_NOT_FOUND);
        }
    }
}
