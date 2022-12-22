package didihttpdns.model;

import android.os.SystemClock;
import com.didi.raven.config.RavenKey;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import didihttpdns.HttpDnsApolloConfig;
import didihttpdns.p230db.DnsConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class DnsRecord implements Serializable {
    private static final int MAX_MIN_TTL = 86400;
    public static final float SOFT_EXPIRE_THRESHOLD = 0.75f;
    private String host;
    private List<IpRecord> ips;
    private Random random = new Random();
    private long respTime = (SystemClock.elapsedRealtime() / 1000);

    /* renamed from: t */
    private int f57036t;
    private int type;

    public String getHost() {
        return this.host;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public List<IpRecord> getIps() {
        return this.ips;
    }

    public void setIps(List<IpRecord> list) {
        this.ips = list;
    }

    public int getT() {
        return this.f57036t;
    }

    public void setT(int i) {
        this.f57036t = Math.max(Math.min(HttpDnsApolloConfig.getConfig().getMinTTL(), 86400), i);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getAvailableIp() {
        List<IpRecord> list = this.ips;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<IpRecord> list2 = this.ips;
        IpRecord ipRecord = list2.get(this.random.nextInt(list2.size()));
        if (ipRecord == null) {
            return null;
        }
        return ipRecord.getIp();
    }

    public boolean isSoftExpired() {
        return ((float) (SystemClock.elapsedRealtime() / 1000)) >= ((float) this.respTime) + (((float) this.f57036t) * 0.75f);
    }

    public boolean isExpired() {
        return SystemClock.elapsedRealtime() / 1000 >= this.respTime + ((long) this.f57036t);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("[host:");
        sb.append(this.host);
        sb.append(", ips:");
        List<IpRecord> list = this.ips;
        if (list == null) {
            str = "";
        } else {
            str = list.toString();
        }
        sb.append(str);
        sb.append(", t:");
        sb.append(this.f57036t);
        sb.append(", respTime:");
        sb.append(this.respTime);
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public static DnsRecord parseFromJsonObject(JSONObject jSONObject) {
        DnsRecord dnsRecord = new DnsRecord();
        dnsRecord.setHost(jSONObject.optString("host"));
        dnsRecord.setT(jSONObject.optInt(RavenKey.TYPE));
        JSONArray optJSONArray = jSONObject.optJSONArray(DnsConstants.IPS);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(IpRecord.parseFromJsonObject(optJSONObject));
                }
            }
            dnsRecord.setIps(arrayList);
        }
        return dnsRecord;
    }
}
