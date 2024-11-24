package sopt35.linkareer.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sopt35.linkareer.api.dto.response.AddBookmarkResponse;
import sopt35.linkareer.api.dto.response.DeleteBookmarkResponse;
import sopt35.linkareer.api.dto.response.OfficialListResponse;
import sopt35.linkareer.domain.official.application.dto.response.OfficialDto;
import sopt35.linkareer.domain.official.application.service.OfficialService;
import sopt35.linkareer.domain.official.validator.CategoryValidator;

import java.util.List;
import sopt35.linkareer.global.util.HeaderExtracter;

@RestController
@RequestMapping("/api/v1")
public class OfficialController {

    private final OfficialService officialService;
    private final CategoryValidator categoryValidator;
    private final HeaderExtracter headerExtracter;

    public OfficialController(OfficialService officialService, CategoryValidator categoryValidator, HeaderExtracter headerExtracter) {
        this.officialService = officialService;
        this.categoryValidator = categoryValidator;
        this.headerExtracter = headerExtracter;
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



    @PostMapping("/bookmark/{officialId}")
    ResponseEntity<AddBookmarkResponse> createBookMarkOfficial(HttpServletRequest req, @PathVariable final long officialId){
        headerExtracter.extractMemberIdHeader(req);
        officialService.addBookMark(officialId);
        return ResponseEntity.ok(AddBookmarkResponse.of("북마크 추가에 성공하였습니다!"));
    }

    @DeleteMapping("/bookmark/{officialId}")
    ResponseEntity<DeleteBookmarkResponse> deleteBookMarkOfficial(HttpServletRequest req, @PathVariable final long officialId){
        headerExtracter.extractMemberIdHeader(req);
        officialService.deleteBookMark(officialId);
        return ResponseEntity.ok(DeleteBookmarkResponse.of("해당 공고 북마크 제거에 성공하였습니다"));
    }


}
