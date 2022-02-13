package foundation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserNoticeParams {

    @SerializedName("msg-id")
    @Expose
    private Object msgId;

    public Object getMsgId() {
        return msgId;
    }

    public void setMsgId(Object msgId) {
        this.msgId = msgId;
    }

}
