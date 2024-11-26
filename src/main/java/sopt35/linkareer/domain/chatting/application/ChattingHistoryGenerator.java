package sopt35.linkareer.domain.chatting.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import sopt35.linkareer.annotation.Generator;
import sopt35.linkareer.domain.chatting.application.vo.ChattingHistoryVo;
import sopt35.linkareer.domain.chatting.application.vo.ChatVo;

@Generator
public class ChattingHistoryGenerator {


    public ChattingHistoryVo getChattingHistory(List<ChatVo> findChats) {
       return addRandomOrderChat(findChats);
    }

    private ChattingHistoryVo addRandomOrderChat(List<ChatVo> findChats) {
        List<ChatVo> partnerChat = new ArrayList<>();
        List<ChatVo> myChat = new ArrayList<>();
        List<Integer> orders = randomOrders();
        for (int idx = 0; idx < findChats.size(); idx++) {
            ChatVo convertedEntity = findChats.get(orders.get(idx));
            if (idx % 2 == 0)
                addMyChat(myChat, convertedEntity);
            else
                addPartnerChat(partnerChat, convertedEntity);
        }
        sortedChat(myChat, partnerChat);
        return ChattingHistoryVo.of(myChat, partnerChat);
    }

    private void sortedChat(List<ChatVo> myChat, List<ChatVo> partnerChat) {
        myChat.sort(Comparator.comparing(ChatVo::createdTime));
        partnerChat.sort(Comparator.comparing(ChatVo::createdTime));
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
