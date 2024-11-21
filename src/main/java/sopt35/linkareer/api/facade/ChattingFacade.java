package sopt35.linkareer.api.facade;

import sopt35.linkareer.annotation.Facade;
import sopt35.linkareer.domain.chatting.application.dto.response.ChattingHistoryServiceResponse;
import sopt35.linkareer.domain.chatting.application.service.ChattingService;

@Facade
public class ChattingFacade {

    private final ChattingService chattingService;
    // 추후 다른 도메인이 들어오면 facade에서 같이 로직 사용


    public ChattingFacade(ChattingService chattingService) {
        this.chattingService = chattingService;
    }

    public ChattingHistoryServiceResponse getChattingHistory(long memberId) {
        return chattingService.getHistory(memberId);
    }
}
