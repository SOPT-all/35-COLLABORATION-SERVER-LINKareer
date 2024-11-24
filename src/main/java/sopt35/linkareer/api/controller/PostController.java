package sopt35.linkareer.api.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt35.linkareer.api.dto.response.PostsApiResponse;
import sopt35.linkareer.api.facade.PostFacade;
import sopt35.linkareer.domain.post.application.dto.response.PostsServiceResponse;
import sopt35.linkareer.domain.post.application.vo.PostVo;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @GetMapping
    public ResponseEntity<PostsApiResponse> getPosts(
            final @RequestHeader Long memberId
    ) {
        PostsApiResponse postsApiResponse = postFacade.getPosts();

        return ResponseEntity.ok(postsApiResponse);
    }
}
