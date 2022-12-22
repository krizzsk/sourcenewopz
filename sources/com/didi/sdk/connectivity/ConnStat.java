package com.didi.sdk.connectivity;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.didi.app.nova.support.util.TimeUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnStat implements Serializable {
    int cost;
    String description;
    long endTime;
    int errno;
    String host;

    /* renamed from: ip */
    String f35724ip;
    String pingResult;
    int port;
    private SimpleDateFormat sdf = new SimpleDateFormat(TimeUtils.DATE_FORMAT_TYPE_4);
    long startTime;
    boolean success;
    String tracertResult;

    public ConnStat(String str, int i, int i2, String str2, int i3) {
        this.f35724ip = str;
        this.port = i;
        this.errno = i2;
        this.description = str2;
        this.cost = i3;
        this.success = TextUtils.isEmpty(str2) && i3 > 0;
    }

    public String toString() {
        return "ConnStat{startTime=" + this.sdf.format(Long.valueOf(this.startTime)) + ", endTime=" + this.sdf.format(Long.valueOf(this.endTime)) + ", host='" + this.host + '\'' + ", ip='" + this.f35724ip + '\'' + ", port=" + this.port + ", errno=" + this.errno + ", description='" + this.description + '\'' + ", cost=" + this.cost + ", success=" + this.success + ", pingResult='" + this.pingResult + '\'' + ", tracertResult='" + this.tracertResult + '\'' + '}';
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_time", this.sdf.format(Long.valueOf(this.startTime)));
            jSONObject.put("end_time", this.sdf.format(Long.valueOf(this.endTime)));
            jSONObject.put("domain", this.host);
            jSONObject.put("addr", this.f35724ip);
            jSONObject.put(NotificationCompat.CATEGORY_ERROR, this.errno);
            jSONObject.put("desc", this.description);
            jSONObject.put("time", this.cost);
            jSONObject.put("ping", this.pingResult);
            jSONObject.put("tracert", this.tracertResult);
            return jSONObject;
        } catch (JSONException e) {
            SystemUtils.log(3, "didi-connectivity", Log.getStackTraceString(e), (Throwable) null, "com.didi.sdk.connectivity.ConnStat", 85);
            return null;
        }
    }
}
