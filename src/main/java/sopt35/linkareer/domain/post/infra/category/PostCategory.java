package sopt35.linkareer.domain.post.infra.category;

import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.global.exception.LinkareerException;

public enum PostCategory {
    INTEREST,
    JOB;

    public static PostCategory from(final String category) {
        try {
            return PostCategory.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new LinkareerException(ErrorCode.CATEGORY_NOT_FOUND);
        }
    }
}
