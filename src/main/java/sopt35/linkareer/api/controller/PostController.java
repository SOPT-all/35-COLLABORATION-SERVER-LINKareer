package sopt35.linkareer.api.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt35.linkareer.api.dto.response.PostsApiResponse;
import sopt35.linkareer.api.facade.PostFacade;
import sopt35.linkareer.domain.post.validator.PostCategoryValidator;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostFacade postFacade;
    private final PostCategoryValidator postCategoryValidator;

    public PostController(PostFacade postFacade, PostCategoryValidator postCategoryValidator) {
        this.postFacade = postFacade;
        this.postCategoryValidator = postCategoryValidator;
    }

    @GetMapping
    public ResponseEntity<PostsApiResponse> getPosts(
            final @RequestHeader Long memberId,
            final @RequestParam("category") String category
    ) {
        postCategoryValidator.validate(category);
        PostsApiResponse postsApiResponse = postFacade.getPosts();

        return ResponseEntity.ok(postsApiResponse);
    }
}
