package sopt35.linkareer.domain.chatting.application.dto.response;

import sopt35.linkareer.domain.chatting.application.vo.ChattingHistoryVo;
import sopt35.linkareer.domain.chatting.application.vo.ChatPartnerVo;
import sopt35.linkareer.domain.chatting.application.vo.ChatRoomVo;
import sopt35.linkareer.domain.chatting.application.vo.MyChatInfo;
import sopt35.linkareer.domain.chatting.application.vo.PartnerVo;

public record ChattingHistoryServiceResponse(String chatRoomName, int chatParticiPantsCount,
                                             ChatPartnerVo chatPartner,
                                             MyChatInfo myChat
) {

    public static ChattingHistoryServiceResponse of(ChatRoomVo chatRoomVo,
        PartnerVo partnerVo, ChattingHistoryVo chattingHistoryVo) {
        return new ChattingHistoryServiceResponse(chatRoomVo.chatRoomName(),
            chatRoomVo.chatParticipantsCount(),
            ChatPartnerVo.of(partnerVo.partnerName(), partnerVo.isBlueChecked(),
                partnerVo.tag(), chattingHistoryVo.partnerChats()),
            MyChatInfo.of(chattingHistoryVo.myChats()));
    }

}
