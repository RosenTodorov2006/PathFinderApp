package bg.soft_uni.pathfinderapp.Model.Dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Blob;

public class AddRouteDto {
    @NotNull(message = "Invalid Name")
    @NotEmpty(message = "Invali dName")
    private String name;
    @NotNull(message = "Invalid Description")
    @NotEmpty(message = "Invalid Description")
    @Length(min = 5, message = "Description is too small")
    private String description;

    //private Blob gpxCoordinates;
    @NotNull(message = "Invalid level")
    @NotEmpty(message = "Invalid level")
    private String level;

    @NotNull(message = "Invalid videoUrl")
    @NotEmpty(message = "Invalid videoUrl")
    private String videoUrl;
    private String categories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

//    public Blob getGpxCoordinates() {
//        return gpxCoordinates;
//    }
//
//    public void setGpxCoordinates(Blob gpxCoordinates) {
//        this.gpxCoordinates = gpxCoordinates;
//    }


    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
