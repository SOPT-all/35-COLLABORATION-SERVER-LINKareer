package sopt35.linkareer.domain.chatting.application;

import java.util.List;
import java.util.Random;
import sopt35.linkareer.annotation.Generator;

@Generator
public class NameGenerator {

    private static final List<String> partnerNames = List.of("무관심한 곰", "겨울엔 대방어", "토끼는토끼", "도비는자유", "빨간모자");
    private final Random random = new Random();

    public String generatePartnerName(){
        return partnerNames.get(random.nextInt(0, partnerNames.size()));
    }
}
