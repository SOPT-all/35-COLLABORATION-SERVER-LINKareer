package sopt35.linkareer.domain.chatting.application;

import java.util.List;
import java.util.Random;
import sopt35.linkareer.annotation.Generator;
import sopt35.linkareer.domain.chatting.application.vo.ChatRoomVo;

@Generator
public class ChatRoomInfoGenerator {

    private static final List<String> chatRoomName = List.of("취직을향해", "sopt는취직100프로?", "취뽀받자", "취준정보방", "취직인포매틱스");

    private final Random random = new Random();

    public ChatRoomVo generateChatRoomInfo(){
        return ChatRoomVo.of(generateChatRoomName(), generateChatParticipantsCount());
    }

    private String generateChatRoomName(){
        return chatRoomName.get(random.nextInt(0, chatRoomName.size()));
    }

    private int generateChatParticipantsCount(){
        return random.nextInt(1500, 2000) + 1;
    }


}
