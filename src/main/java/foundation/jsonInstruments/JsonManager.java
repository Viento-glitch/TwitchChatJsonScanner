package foundation.jsonInstruments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import foundation.Message;
import foundation.jsonInstruments.Commenter;

public class JsonManager {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("channel_id")
    @Expose
    private String channelId;
    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("content_id")
    @Expose
    private String contentId;
    @SerializedName("content_offset_seconds")
    @Expose
    private Double contentOffsetSeconds;
    @SerializedName("commenter")
    @Expose
    private Commenter commenter;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("more_replies")
    @Expose
    private Boolean moreReplies;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Double getContentOffsetSeconds() {
        return contentOffsetSeconds;
    }

    public void setContentOffsetSeconds(Double contentOffsetSeconds) {
        this.contentOffsetSeconds = contentOffsetSeconds;
    }

    public Commenter getCommenter() {
        return commenter;
    }

    public void setCommenter(Commenter commenter) {
        this.commenter = commenter;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Boolean getMoreReplies() {
        return moreReplies;
    }

    public void setMoreReplies(Boolean moreReplies) {
        this.moreReplies = moreReplies;
    }

}
