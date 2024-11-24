package sopt35.linkareer.domain.post.application.dto.response;

import java.util.List;
import sopt35.linkareer.domain.post.application.vo.PostVo;

public record PostsServiceResponse(
        List<PostVo> posts
) {
    public static PostsServiceResponse toPostsServiceResponse(final List<PostVo> posts) {
        return new PostsServiceResponse(posts);
    }
}
