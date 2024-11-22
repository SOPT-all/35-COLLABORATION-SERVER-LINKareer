package sopt35.linkareer.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.api.dto.response.OfficialListResponse;
import sopt35.linkareer.domain.official.application.dto.response.OfficialDto;
import sopt35.linkareer.domain.official.application.service.OfficialService;
import sopt35.linkareer.domain.official.infra.Official.Category;
import sopt35.linkareer.global.exception.LinkareerException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OfficialController {

    private final OfficialService officialService;

    public OfficialController(OfficialService officialService) {
        this.officialService = officialService;
    }

    // 카테고리에 맞는 공고 리스트를 조회하는 API
    @GetMapping("/officiallist")
    ResponseEntity<OfficialListResponse> getOfficialList(
            @Validated @RequestHeader Long memberId,
            @Validated @RequestParam(value = "category") String category
    ) {
        List<OfficialDto> officialList = officialService.getOfficialListByCategory(
                memberId,
                validateCreateCategory(category)
        );
        return ResponseEntity.ok(OfficialListResponse.from(officialList));
    }

    // 카테고리 유효성 검사 메서드
    private Category validateCreateCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new LinkareerException(ErrorCode.INVALID_INPUT_CATEGORY_VALUE);
        }
        return validateCategory(category);
    }

    // 카테고리 값을 검증하고 변환하는 메서드
    private Category validateCategory(String category) {
        try {
            return Category.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new LinkareerException(ErrorCode.CATEGORY_NOT_FOUND);
        }
    }
}
