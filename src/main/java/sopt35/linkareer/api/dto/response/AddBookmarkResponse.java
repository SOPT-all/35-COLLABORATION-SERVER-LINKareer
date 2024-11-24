package sopt35.linkareer.api.dto.response;

public record AddBookmarkResponse(String message) {
    public static AddBookmarkResponse of(String message) {
        return new AddBookmarkResponse(message);
    }
}
