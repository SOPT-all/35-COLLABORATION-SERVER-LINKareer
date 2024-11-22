package sopt35.linkareer.domain.chatting.application.vo;



public record TagVo(String companyName, String job) {

    public static TagVo of(String companyName, String job) {
        return new TagVo(companyName, job);
    }
}
