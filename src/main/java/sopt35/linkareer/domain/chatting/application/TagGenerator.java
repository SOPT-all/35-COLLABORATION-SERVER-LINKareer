package sopt35.linkareer.domain.chatting.application;

import java.util.List;
import java.util.Random;
import sopt35.linkareer.annotation.Generator;
import sopt35.linkareer.domain.chatting.application.vo.TagVo;

@Generator
public class TagGenerator {

    private static final List<String> companyNames = List.of("삼성전자", "LG전자", "SK하이닉스", "네이버", "카카오");
    private static final List<String> jobs = List.of("개발자", "디자이너", "기획자", "마케터", "연구원");
    private final Random random = new Random();

    public TagVo pickRandomTag() {
        String companyName = companyNames.get(random.nextInt(0, companyNames.size()));
        String job = jobs.get(random.nextInt(0, jobs.size()));
        return TagVo.of(companyName, job);
    }
}
