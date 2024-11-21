package sopt35.linkareer.domain.official.infra;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private Integer views;

    @Column(nullable = false)
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
}
