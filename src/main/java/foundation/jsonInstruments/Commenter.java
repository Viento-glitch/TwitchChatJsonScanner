package foundation.jsonInstruments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Commenter {
    public Commenter(String displayName, String id, String name, String type, String bio, String createdAt, String updatedAt, String logo) {
        this.displayName = displayName;
        this.id = id;
        this.name = name;
        this.type = type;
        this.bio = bio;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.logo = logo;
    }

    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("logo")
    @Expose
    private String logo;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
