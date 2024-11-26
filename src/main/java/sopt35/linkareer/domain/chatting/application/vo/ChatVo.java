package sopt35.linkareer.domain.chatting.application.vo;

import sopt35.linkareer.domain.chatting.infra.ChattingEntity;

public record ChatVo(String message, boolean isReplied, int likes, boolean pressedLike,
                     String createdTime, ReplyVo reply) {

    public static ChatVo of(String message, boolean isReplied, int likes, boolean pressedLike,
        String createdDate, ReplyVo reply) {
        return new ChatVo(message, isReplied, likes, pressedLike, createdDate, reply);
    }

    public static ChatVo toChatVo(ChattingEntity chattingEntity) {
        return new ChatVo(chattingEntity.getMessage(), chattingEntity.getIsReplied(),
            chattingEntity.getLikes(), chattingEntity.getPressedLike(),
            chattingEntity.getCreatedAt().toLocalTime().toString(),
            ReplyVo.of(chattingEntity.getReplyMessage(), chattingEntity.getReplySender()));
    }
}
