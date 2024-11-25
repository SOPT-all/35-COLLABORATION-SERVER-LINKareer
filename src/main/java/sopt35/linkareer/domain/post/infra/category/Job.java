package sopt35.linkareer.domain.post.infra.category;

import java.util.Arrays;
import java.util.List;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.global.exception.LinkareerException;

public enum Job {
    DESIGN("디자인"),
    PRODUCT_DESIGN("프로덕트 디자인"),
    UX_UI("UX/UI");

    private final String name;

    Job(String name) {
        this.name = name;
    }

    public static Job findJobByName(final String name) {
        return Arrays.stream(Job.values())
                .filter(job -> job.getName().equals(name))
                .findFirst()
                .orElseThrow(
                        () -> new LinkareerException(ErrorCode.CATEGORY_NOT_FOUND)
                );
    }

    public String getName() {
        return name;
    }
}
