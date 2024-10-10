package bg.soft_uni.pathfinderapp.Model.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @Column(nullable = false)
    private boolean approved;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false, name = "text_content", columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "author_id")
    private User authorId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "route_id")
    private Route routeId;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
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

    public Route getRouteId() {
        return routeId;
    }

    public void setRouteId(Route routeId) {
        this.routeId = routeId;
    }
}
