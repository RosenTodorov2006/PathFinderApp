package bg.soft_uni.pathfinderapp.Model.Entities;

import bg.soft_uni.pathfinderapp.Model.Entities.Enums.Level;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Column
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(nullable = false)
    private String name;
    @Column(name = "video_url")
    private String videoUrl;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "author_id")
    private User user;
    @OneToMany(mappedBy = "routeId")
    private List<Picture> picture;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Category> categories;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Picture> getPicture() {
        return picture;
    }

    public void setPicture(List<Picture> picture) {
        this.picture = picture;
    }
}
