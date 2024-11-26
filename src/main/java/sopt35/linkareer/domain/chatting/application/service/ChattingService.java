package sopt35.linkareer.domain.chatting.application.service;


import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt35.linkareer.api.dto.response.ErrorCode;
import sopt35.linkareer.domain.chatting.application.ChattingHistoryGenerator;
import sopt35.linkareer.domain.chatting.application.ChatPartnerGenerator;
import sopt35.linkareer.domain.chatting.application.ChatRoomInfoGenerator;
import sopt35.linkareer.domain.chatting.application.dto.response.ChattingHistoryServiceResponse;
import sopt35.linkareer.domain.chatting.application.vo.ChattingHistoryVo;
import sopt35.linkareer.domain.chatting.application.vo.ChatVo;
import sopt35.linkareer.domain.chatting.application.vo.ChatRoomVo;
import sopt35.linkareer.domain.chatting.application.vo.PartnerVo;
import sopt35.linkareer.domain.chatting.infra.repository.ChattingRepository;
import sopt35.linkareer.global.exception.LinkareerException;

@Service
public class ChattingService {

    private final ChattingRepository chattingRepository;
    private final ChatRoomInfoGenerator chatRoomInfoGenerator;
    private final ChatPartnerGenerator chatPartnerGenerator;
    private final ChattingHistoryGenerator chattingHistoryGenerator;

    public ChattingService(ChattingRepository chattingRepository,
        ChatRoomInfoGenerator chatRoomInfoGenerator, ChatPartnerGenerator chatPartnerGenerator, ChattingHistoryGenerator chattingHistoryGenerator
    ) {
        this.chattingRepository = chattingRepository;
        this.chatRoomInfoGenerator = chatRoomInfoGenerator;
        this.chatPartnerGenerator = chatPartnerGenerator;
        this.chattingHistoryGenerator = chattingHistoryGenerator;
    }

    @Transactional(readOnly = true)
    public ChattingHistoryServiceResponse getHistory(long memberId) {
        if (memberId != 1)
            throw new LinkareerException(ErrorCode.INVALID_HEADER_EXCEPTION);

        ChatRoomVo chatRoomVo = chatRoomInfoGenerator.generateChatRoomInfo();
        PartnerVo partnerVo = chatPartnerGenerator.generatePartnerInfo();
        List<ChatVo> findChats = chattingRepository.findAll().stream()
            .map(ChatVo::toChatVo).toList();

        ChattingHistoryVo chattingHistory = chattingHistoryGenerator.getChattingHistory(findChats);

        return ChattingHistoryServiceResponse.of(chatRoomVo, partnerVo, chattingHistory);
    }

}
