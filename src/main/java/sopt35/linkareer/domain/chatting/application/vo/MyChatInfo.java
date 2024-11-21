package sopt35.linkareer.domain.chatting.application.vo;

import java.util.List;

public record MyChatInfo(List<ChatVo> chatList) {

    public static MyChatInfo of(List<ChatVo> chatList) {
        return new MyChatInfo(chatList);
    }
}
