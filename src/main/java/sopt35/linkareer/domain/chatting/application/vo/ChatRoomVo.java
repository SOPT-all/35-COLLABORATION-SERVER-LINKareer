package sopt35.linkareer.domain.chatting.application.vo;

public record ChatRoomVo(String chatRoomName, int chatParticipantsCount) {

    public static ChatRoomVo of(String chatRoomName, int chatParticipantsCount) {
        return new ChatRoomVo(chatRoomName, chatParticipantsCount);
    }

}
