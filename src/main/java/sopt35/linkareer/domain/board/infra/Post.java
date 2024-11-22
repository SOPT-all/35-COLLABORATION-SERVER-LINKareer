package sopt35.linkareer.domain.board.infra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private String community;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ColumnDefault("0")
    private int favorites;

    @ColumnDefault("0")
    private int comments;

    @ColumnDefault("0")
    private int views;

    protected Post() {}

    public Post(final Long id, final String job, final String community, final String imageUrl, final String title, final String content, final String writer,
                final LocalDateTime createdAt, final int favorites, final int comments, final int views) {
        this.id = id;
        this.job = job;
        this.community = community;
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.favorites = favorites;
        this.comments = comments;
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public String getCommunity() {
        return community;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getFavorites() {
        return favorites;
    }

    public int getComments() {
        return comments;
    }

    public int getViews() {
        return views;
    }
}
