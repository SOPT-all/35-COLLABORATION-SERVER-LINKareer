package sopt35.linkareer.api.dto.response;

import java.util.List;
import sopt35.linkareer.domain.post.application.dto.response.PostsServiceResponse;
import sopt35.linkareer.domain.post.application.vo.PostVo;

public record PostsApiResponse(
        List<PostVo> posts
) {
    public static PostsApiResponse toPostsApiResponse(final PostsServiceResponse postsServiceResponse) {
        return new PostsApiResponse(
                postsServiceResponse.posts()
        );
    }
}
