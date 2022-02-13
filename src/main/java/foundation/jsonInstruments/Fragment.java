package foundation.jsonInstruments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fragment {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("emoticon")
    @Expose
    private Object emoticon;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(Object emoticon) {
        this.emoticon = emoticon;
    }

}
