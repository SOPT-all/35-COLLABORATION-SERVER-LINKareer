package sopt35.linkareer.api.dto.response;

import java.util.List;
import sopt35.linkareer.domain.post.application.dto.response.PostsServiceResponse;
import sopt35.linkareer.domain.post.application.vo.PostsVo;

public record PostsApiResponse(
        PostsVo posts
) {
    public static PostsApiResponse toPostsApiResponse(final PostsServiceResponse postsServiceResponse) {
        return new PostsApiResponse(
                postsServiceResponse.posts()
        );
    }
}
