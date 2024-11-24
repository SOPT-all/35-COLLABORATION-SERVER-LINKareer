package sopt35.linkareer.api.dto.response;

public record DeleteBookmarkResponse(String message) {

    public static DeleteBookmarkResponse of(String message) {
        return new DeleteBookmarkResponse(message);
    }

}
