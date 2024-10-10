package bg.soft_uni.pathfinderapp.Model.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Messages extends BaseEntity{
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "text_content", columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "author_id")
    private User authorId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "recipient_id")
    private User recipientId;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public User getAuthorId() {
        return authorId;
    }

    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }

    public User getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(User recipientId) {
        this.recipientId = recipientId;
    }
}
