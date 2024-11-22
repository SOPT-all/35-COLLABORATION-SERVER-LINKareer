package sopt35.linkareer.domain.chatting.application;

import sopt35.linkareer.annotation.Generator;
import sopt35.linkareer.domain.chatting.application.vo.PartnerVo;
import sopt35.linkareer.domain.chatting.application.vo.TagVo;

@Generator
public class ChatPartnerGenerator {

    private final BlueCheckGenerator blueCheckGenerator;
    private final TagGenerator tagGenerator;
    private final NameGenerator nameGenerator;

    public ChatPartnerGenerator(BlueCheckGenerator blueCheckGenerator, TagGenerator tagGenerator,
        NameGenerator nameGenerator) {
        this.blueCheckGenerator = blueCheckGenerator;
        this.tagGenerator = tagGenerator;
        this.nameGenerator = nameGenerator;
    }

    public PartnerVo generatePartnerInfo(){
        String name = nameGenerator.generatePartnerName();
        boolean blueChecked = blueCheckGenerator.pickBlueChecked();
        TagVo tag = tagGenerator.pickRandomTag();
        return PartnerVo.of(name, blueChecked, tag);
    }


}
