package sopt35.linkareer.domain.official.infra;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Official {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String interestJob;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String tag;

    @ColumnDefault("0")
    private Integer views;

    @ColumnDefault("0")
    private Integer comments;

    @Column(nullable = false)
    private String dDay;

    @Column(nullable = false)
    private boolean bookmark = false;

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

    // 카테고리 Enum
    public enum Category {
        RECOMMEND, // 추천 공고
        POPULAR // 실시간 인기 공고
    }

}
