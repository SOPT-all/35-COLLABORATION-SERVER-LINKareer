package sopt35.linkareer.domain.chatting.application.dto.response;

import java.util.List;
import sopt35.linkareer.domain.chatting.application.vo.ChatVo;
import sopt35.linkareer.domain.chatting.application.vo.ChatPartnerVo;
import sopt35.linkareer.domain.chatting.application.vo.ChatRoomVo;
import sopt35.linkareer.domain.chatting.application.vo.MyChatInfo;
import sopt35.linkareer.domain.chatting.application.vo.PartnerVo;

public record ChattingHistoryServiceResponse(String chatRoomName, int chatParticiPantsCount,
                                             ChatPartnerVo chatPartner,
                                             MyChatInfo myChat
) {

    public static ChattingHistoryServiceResponse of(ChatRoomVo chatRoomVo,
        PartnerVo partnerVo, List<ChatVo> partnerChat, List<ChatVo> myChat) {
        return new ChattingHistoryServiceResponse(chatRoomVo.chatRoomName(),
            chatRoomVo.chatParticipantsCount(),
            ChatPartnerVo.of(partnerVo.partnerName(), partnerVo.isBlueChecked(),
                partnerVo.tag(), partnerChat),
            MyChatInfo.of(myChat));
    }

}
