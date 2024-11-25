package sopt35.linkareer.domain.post.application.vo;

import sopt35.linkareer.domain.post.infra.Post;

public record PostVo(
        long id,
        String job,
        String community,
        String imageUrl,
        String title,
        String content,
        String writer,
        String beforeTime,
        int favorites,
        int comments,
        int views
) {
    public static PostVo of(final Post post, final String beforeTime) {
        return new PostVo(
                post.getId(),
                post.getJob(),
                post.getCommunity(),
                post.getImageUrl(),
                post.getTitle(),
                post.getContent(),
                post.getWriter(),
                beforeTime,
                post.getFavorites(),
                post.getComments(),
                post.getViews()
        );
    }
}
