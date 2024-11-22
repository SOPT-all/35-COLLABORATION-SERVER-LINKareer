package sopt35.linkareer.domain.chatting.application.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt35.linkareer.domain.chatting.application.ChatPartnerGenerator;
import sopt35.linkareer.domain.chatting.application.ChatRoomInfoGenerator;
import sopt35.linkareer.domain.chatting.application.dto.response.ChattingHistoryServiceResponse;
import sopt35.linkareer.domain.chatting.application.vo.ChatVo;
import sopt35.linkareer.domain.chatting.application.vo.ChatRoomVo;
import sopt35.linkareer.domain.chatting.application.vo.PartnerVo;
import sopt35.linkareer.domain.chatting.infra.repository.ChattingRepository;

@Service
public class ChattingService {

    private final ChattingRepository chattingRepository;
    private final ChatRoomInfoGenerator chatRoomInfoGenerator;
    private final ChatPartnerGenerator chatPartnerGenerator;

    public ChattingService(ChattingRepository chattingRepository,
        ChatRoomInfoGenerator chatRoomInfoGenerator, ChatPartnerGenerator chatPartnerGenerator
    ) {
        this.chattingRepository = chattingRepository;
        this.chatRoomInfoGenerator = chatRoomInfoGenerator;
        this.chatPartnerGenerator = chatPartnerGenerator;
    }

    @Transactional(readOnly = true)
    public ChattingHistoryServiceResponse getHistory(long memberId) {
        if (memberId != 1)
            throw new IllegalArgumentException("잘못된 사용자입니다.");

        ChatRoomVo chatRoomVo = chatRoomInfoGenerator.generateChatRoomInfo();
        PartnerVo partnerVo = chatPartnerGenerator.generatePartnerInfo();
        List<ChatVo> findChats = chattingRepository.findAll().stream()
            .map(ChatVo::toChatVo).toList();
        List<ChatVo> partnerChat = new ArrayList<>();
        List<ChatVo> myChat = new ArrayList<>();
        addChatList(findChats, partnerChat, myChat);

        return ChattingHistoryServiceResponse.of(chatRoomVo, partnerVo, partnerChat, myChat);
    }

    private void addChatList(List<ChatVo> all, List<ChatVo> partnerChat,
        List<ChatVo> myChat) {
        List<Integer> orders = randomOrders();
        for (int i = 0; i < all.size(); i++) {
            ChatVo convertedEntity = all.get(orders.get(i));
            if (i % 2 == 0)
                addMyChat(myChat, convertedEntity);
            else
                addPartnerChat(partnerChat, convertedEntity);
        }
    }

    private List<Integer> randomOrders() {
        List<Integer> list = new ArrayList<>(IntStream.rangeClosed(0, 9).boxed()
            .toList());
        Collections.shuffle(list);
        return list;
    }

    private void addMyChat(List<ChatVo> myChat, ChatVo convertedEntity) {
        myChat.add(convertedEntity);
    }

    private void addPartnerChat(List<ChatVo> partnerChat, ChatVo convertedEntity) {
        partnerChat.add(convertedEntity);
    }
}
