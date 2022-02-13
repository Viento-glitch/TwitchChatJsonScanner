package foundation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import foundation.jsonInstruments.Fragment;
import foundation.jsonInstruments.UserBadge;

import java.util.List;

public class Message {

    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("bits_spent")
    @Expose
    private Integer bitsSpent;
    @SerializedName("fragments")
    @Expose
    private List<Fragment> fragments = null;
    @SerializedName("is_action")
    @Expose
    private Boolean isAction;
    @SerializedName("user_badges")
    @Expose
    private List<UserBadge> userBadges = null;
    @SerializedName("user_color")
    @Expose
    private String userColor;
    @SerializedName("user_notice_params")
    @Expose
    private UserNoticeParams userNoticeParams;
    @SerializedName("emoticons")
    @Expose
    private Object emoticons;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getBitsSpent() {
        return bitsSpent;
    }

    public void setBitsSpent(Integer bitsSpent) {
        this.bitsSpent = bitsSpent;
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public Boolean getIsAction() {
        return isAction;
    }

    public void setIsAction(Boolean isAction) {
        this.isAction = isAction;
    }

    public List<UserBadge> getUserBadges() {
        return userBadges;
    }

    public void setUserBadges(List<UserBadge> userBadges) {
        this.userBadges = userBadges;
    }

    public String getUserColor() {
        return userColor;
    }

    public void setUserColor(String userColor) {
        this.userColor = userColor;
    }

    public UserNoticeParams getUserNoticeParams() {
        return userNoticeParams;
    }

    public void setUserNoticeParams(UserNoticeParams userNoticeParams) {
        this.userNoticeParams = userNoticeParams;
    }

    public Object getEmoticons() {
        return emoticons;
    }

    public void setEmoticons(Object emoticons) {
        this.emoticons = emoticons;
    }

}
