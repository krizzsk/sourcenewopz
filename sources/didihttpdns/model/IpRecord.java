package didihttpdns.model;

import java.io.Serializable;
import org.json.JSONObject;

public class IpRecord implements Serializable {

    /* renamed from: ip */
    private String f57037ip;

    public String getIp() {
        return this.f57037ip;
    }

    public void setIp(String str) {
        this.f57037ip = str;
    }

    public String toString() {
        return this.f57037ip;
    }

    public static IpRecord parseFromJsonObject(JSONObject jSONObject) {
        IpRecord ipRecord = new IpRecord();
        ipRecord.f57037ip = jSONObject.optString("ip");
        return ipRecord;
    }
}
