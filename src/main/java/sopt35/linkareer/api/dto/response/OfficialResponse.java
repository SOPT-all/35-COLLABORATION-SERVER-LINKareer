package sopt35.linkareer.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import sopt35.linkareer.domain.official.application.dto.response.OfficialDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficialResponse {
    private final long id;
    private String interestJob;
    private String imageUrl;
    private String title;
    private String companyName;
    private String tag;
    private Integer views;
    private Integer comments;
    private String dDay;
    private boolean bookmark;

    public OfficialResponse(Long id, String interestJob, String imageUrl, String title, String companyName, String tag, Integer views, Integer comments, String dDay, boolean bookmark) {
        this.id = id;
        this.interestJob = interestJob;
        this.imageUrl = imageUrl;
        this.title = title;
        this.companyName = companyName;
        this.tag = tag;
        this.views = views;
        this.comments = comments;
        this.dDay = dDay;
        this.bookmark = bookmark;
    }

    public static OfficialResponse from(OfficialDto officialDto) {
        return new OfficialResponse(
                officialDto.getId(),
                officialDto.getInterestJob(),
                officialDto.getImageUrl(),
                officialDto.getTitle(),
                officialDto.getCompanyName(),
                officialDto.getTag(),
                officialDto.getViews(),
                officialDto.getComments(),
                officialDto.getDDay(),
                officialDto.isBookmark()
        );
    }

    // Getters
    public Long getId() { return id; }
    public String getInterestJob() { return interestJob; }
    public String getImageUrl() { return imageUrl; }
    public String getTitle() { return title; }
    public String getCompanyName() { return companyName; }
    public String getTag() { return tag; }
    public Integer getViews() { return views; }
    public Integer getComments() { return comments; }
    public String getDDay() { return dDay; }
    public boolean isBookmark() { return bookmark; }
}
