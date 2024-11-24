package sopt35.linkareer.api.facade;

import java.util.List;
import sopt35.linkareer.annotation.Facade;
import sopt35.linkareer.api.dto.response.PostsApiResponse;
import sopt35.linkareer.domain.post.application.service.PostService;
import sopt35.linkareer.domain.post.application.vo.PostVo;

@Facade
public class PostFacade {

    private final PostService postService;

    public PostFacade(PostService postService) {
        this.postService = postService;
    }

    public PostsApiResponse getPosts() {
        return PostsApiResponse.toPostsApiResponse(
                postService.getPosts()
        );
    }
}
