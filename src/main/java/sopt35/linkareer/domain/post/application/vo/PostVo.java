package sopt35.linkareer.domain.post.application.vo;

public record PostVo(
        long id,
        String job,
        String community,
        String imageUrl,
        String title,
        String content,
        String writer,
        int beforeHour,
        int favorites,
        int comments,
        int views
) {

}
