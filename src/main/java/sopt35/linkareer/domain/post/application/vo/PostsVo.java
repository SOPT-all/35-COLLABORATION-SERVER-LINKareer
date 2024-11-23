package sopt35.linkareer.domain.post.application.vo;

import java.util.List;

public record PostsVo(
        List<PostVo> posts
) {
    public static PostsVo toPostsVo(final List<PostVo> posts) {
        return new PostsVo(posts);
    }
}
