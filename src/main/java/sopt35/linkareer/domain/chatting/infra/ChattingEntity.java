package sopt35.linkareer.domain.chatting.infra;

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

@Entity(name = "chatting")
@EntityListeners(AuditingEntityListener.class)
public class ChattingEntity {

    protected ChattingEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private boolean isReplied;

    private String replyMessage;

    private String replySender;

    @ColumnDefault("0")
    private int likes;

    private boolean pressedLike;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsReplied() {
        return isReplied;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public String getReplySender() {
        return replySender;
    }

    public int getLikes() {
        return likes;
    }

    public boolean getPressedLike() {
        return pressedLike;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
