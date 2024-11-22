package sopt35.linkareer.domain.chatting.application.vo;

import java.util.List;

public record ChatPartnerVo(String partnerName, boolean isBlueChecked, TagVo tag
, List<ChatVo> chatList
                              ) {

    public static ChatPartnerVo of(String partnerName, boolean isBlueChecked, TagVo tag, List<ChatVo> chatList) {
        return new ChatPartnerVo(partnerName, isBlueChecked, tag, chatList);
    }

}
