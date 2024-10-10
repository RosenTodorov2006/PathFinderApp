package bg.soft_uni.pathfinderapp.Model.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    @Column
    private String title;
    @Column(columnDefinition = "TEXT")
    private String url;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "author_id")
    private User authorId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "route_id")
    private Route routeId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
