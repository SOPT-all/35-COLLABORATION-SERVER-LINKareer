package sopt35.linkareer.domain.chatting.application.vo;

import java.util.List;

public record ChattingHistoryVo(List<ChatVo> myChats, List<ChatVo> partnerChats) {

    public static ChattingHistoryVo of(List<ChatVo> myChats, List<ChatVo> partnerChats) {
        return new ChattingHistoryVo(myChats, partnerChats);
    }

}
