package sopt35.linkareer.domain.chatting.application;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import sopt35.linkareer.annotation.Generator;
import sopt35.linkareer.domain.chatting.application.vo.ChatRoomVo;

@Generator
public class ChatRoomInfoGenerator {

    private static final List<String> chatRoomName = List.of("취직을향해", "sopt는취직100프로?", "취뽀받자",
        "취준정보방", "취직인포매틱스");


    public ChatRoomVo generateChatRoomInfo() {
        return ChatRoomVo.of(generateChatRoomName(), generateChatParticipantsCount());
    }

    private String generateChatRoomName() {
        return chatRoomName.get(ThreadLocalRandom.current().nextInt(0, chatRoomName.size()));
    }

    private int generateChatParticipantsCount() {
        return ThreadLocalRandom.current().nextInt(1500, 2000) + 1;
    }


}
