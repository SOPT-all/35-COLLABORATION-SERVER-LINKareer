package sopt35.linkareer.domain.chatting.application.vo;

public record ReplyVo(String replyMessage, String repliedMessageSenderName) {

    public static ReplyVo of(String replyMessage, String repliedMessageSenderName) {
        return new ReplyVo(replyMessage, repliedMessageSenderName);
    }

}
