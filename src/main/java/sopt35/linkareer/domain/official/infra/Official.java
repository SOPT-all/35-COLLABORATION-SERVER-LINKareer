package sopt35.linkareer.domain.official.infra;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

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
    @Column(nullable = false)
    private int views;

    @ColumnDefault("0")
    @Column(nullable = false)
    private int comments;

    @Column(nullable = false)
    private LocalDate dDay;

    @ColumnDefault("false")
    @Column(nullable = false)
    private boolean bookmark;

    protected Official() {}

    public Official(final Long id, final String interestJob, final String imageUrl, final String title, final String companyName,
                    final String tag, final int views, final int comments, final LocalDate dDay, final boolean bookmark) {
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

    // Getters
    public Long getId() { return id; }
    public String getInterestJob() { return interestJob; }
    public String getImageUrl() { return imageUrl; }
    public String getTitle() { return title; }
    public String getCompanyName() { return companyName; }
    public String getTag() { return tag; }
    public int getViews() { return views; }
    public int getComments() { return comments; }
    public LocalDate getDDay() { return dDay; }
    public boolean isBookmark() { return bookmark; }

    // 카테고리 Enum
    public enum Category {
        RECOMMEND, // 추천 공고
        POPULAR // 실시간 인기 공고
    }

}
