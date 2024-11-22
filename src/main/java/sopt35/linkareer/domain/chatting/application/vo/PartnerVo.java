package sopt35.linkareer.domain.chatting.application.vo;


public record PartnerVo(String partnerName, boolean isBlueChecked, TagVo tag) {

    public static PartnerVo of(String partnerName, boolean isBlueChecked, TagVo tagInfo) {
        return new PartnerVo(partnerName, isBlueChecked, tagInfo);
    }
}
