package sopt35.linkareer.api.facade;

import sopt35.linkareer.annotation.Facade;
import sopt35.linkareer.api.dto.response.PostsApiResponse;
import sopt35.linkareer.domain.post.application.service.PostService;
import sopt35.linkareer.domain.post.infra.category.PostCategory;

@Facade
public class PostFacade {

    private final PostService postService;

    public PostFacade(PostService postService) {
        this.postService = postService;
    }

    public PostsApiResponse getPosts(PostCategory category) {
        return PostsApiResponse.toPostsApiResponse(
                postService.getPosts(category)
        );
    }
}
