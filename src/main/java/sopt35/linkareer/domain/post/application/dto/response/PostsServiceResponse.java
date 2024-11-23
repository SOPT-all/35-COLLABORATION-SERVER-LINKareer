package sopt35.linkareer.domain.post.application.dto.response;

import sopt35.linkareer.domain.post.application.vo.PostsVo;

public record PostsServiceResponse(
        PostsVo posts
) {
    public static PostsServiceResponse toPostsServiceResponse(final PostsVo posts) {
        return new PostsServiceResponse(posts);
    }
}
