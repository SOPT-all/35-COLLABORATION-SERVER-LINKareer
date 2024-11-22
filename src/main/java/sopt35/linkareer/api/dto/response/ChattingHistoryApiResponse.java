package sopt35.linkareer.api.dto.response;

import sopt35.linkareer.domain.chatting.application.dto.response.ChattingHistoryServiceResponse;
import sopt35.linkareer.domain.chatting.application.vo.ChatPartnerVo;
import sopt35.linkareer.domain.chatting.application.vo.MyChatInfo;

public record ChattingHistoryApiResponse(String chatRoomName, int chatParticiPantsCount,
                                         ChatPartnerVo chatPartner,
                                         MyChatInfo myChat) {

    public static ChattingHistoryApiResponse of(ChattingHistoryServiceResponse chattingHistoryServiceResponse) {
        return new ChattingHistoryApiResponse(chattingHistoryServiceResponse.chatRoomName(),
            chattingHistoryServiceResponse.chatParticiPantsCount(),
            chattingHistoryServiceResponse.chatPartner(),
            chattingHistoryServiceResponse.myChat());
    }


}
