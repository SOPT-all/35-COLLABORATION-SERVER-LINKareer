package sopt35.linkareer.domain.official.application.dto.response;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OfficialDto {
    private Long id;
    private final String interestJob;
    private String imageUrl;
    private String title;
    private String companyName;
    private String tag;
    private Integer views;
    private Integer comments;
    private String dDay;
    private boolean bookmark;

    public OfficialDto(Long id, String interestJob, String imageUrl, String title, String companyName, String tag, Integer views, Integer comments, LocalDate dDay, boolean bookmark) {
        this.id = id;
        this.interestJob = interestJob;
        this.imageUrl = imageUrl;
        this.title = title;
        this.companyName = companyName;
        this.tag = tag;
        this.views = views;
        this.comments = comments;
        this.dDay = calculateDDay(dDay);
        this.bookmark = bookmark;
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

    // D-Day 계산 메서드
    private String calculateDDay(LocalDate targetDate) {
        LocalDate today = LocalDate.now(); // 오늘 날짜 기준
        long daysBetween = ChronoUnit.DAYS.between(today, targetDate); // 날짜 차이 계산

        if (daysBetween > 0) {
            return "D-" + daysBetween; // 미래 날짜
        } else if (daysBetween == 0) {
            return "D-Day"; // 오늘
        } else {
            return "D+" + Math.abs(daysBetween); // 과거 날짜
        }
    }
}
