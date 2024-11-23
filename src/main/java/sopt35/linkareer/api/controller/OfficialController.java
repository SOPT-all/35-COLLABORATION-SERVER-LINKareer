package sopt35.linkareer.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sopt35.linkareer.api.dto.response.OfficialListResponse;
import sopt35.linkareer.domain.official.application.dto.response.OfficialDto;
import sopt35.linkareer.domain.official.application.service.OfficialService;
import sopt35.linkareer.domain.official.validator.CategoryValidator;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OfficialController {

    private final OfficialService officialService;
    private final CategoryValidator categoryValidator;

    public OfficialController(OfficialService officialService, CategoryValidator categoryValidator) {
        this.officialService = officialService;
        this.categoryValidator = categoryValidator;
    }

    // 카테고리에 맞는 공고 리스트를 조회하는 API
    @GetMapping("/officiallist")
    ResponseEntity<OfficialListResponse> getOfficialList(
            @Validated @RequestHeader Long memberId,
            @Validated @RequestParam(value = "category") String category
    ) {
        List<OfficialDto> officialList = officialService.getOfficialListByCategory(
                memberId,
                categoryValidator.validate(category)
        );
        return ResponseEntity.ok(OfficialListResponse.from(officialList));
    }


}
