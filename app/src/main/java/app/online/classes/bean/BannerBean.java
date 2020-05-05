package app.online.classes.bean;

public class BannerBean
{
    String id;
    String banner_title;
    String banner_color;
    String description;
    String image;

    public String getImage()
    {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BannerBean(String id, String banner_title, String banner_color, String description, String image)
    {
        this.id = id;
        this.banner_title = banner_title;
        this.banner_color = banner_color;
        this.description = description;
        this.image = image;
    }

    public BannerBean(String id, String banner_title, String banner_color, String description)
    {
        this.id = id;
        this.banner_title = banner_title;
        this.banner_color = banner_color;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBanner_title() {
        return banner_title;
    }

    public void setBanner_title(String banner_title) {
        this.banner_title = banner_title;
    }

    public String getBanner_color() {
        return banner_color;
    }

    public void setBanner_color(String banner_color) {
        this.banner_color = banner_color;
    }
}
