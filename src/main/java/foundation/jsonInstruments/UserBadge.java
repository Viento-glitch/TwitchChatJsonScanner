package foundation.jsonInstruments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserBadge {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("version")
    @Expose
    private String version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
