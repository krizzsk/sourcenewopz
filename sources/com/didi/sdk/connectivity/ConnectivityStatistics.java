package com.didi.sdk.connectivity;

import com.didi.raven.config.RavenKey;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConnectivityStatistics {

    /* renamed from: n */
    private static final SimpleDateFormat f35735n = new SimpleDateFormat("yyyyMMdd_HH:mm:ss.SSS");

    /* renamed from: a */
    long f35736a;

    /* renamed from: b */
    long f35737b;

    /* renamed from: c */
    int f35738c;

    /* renamed from: d */
    double f35739d;

    /* renamed from: e */
    double f35740e;

    /* renamed from: f */
    int f35741f;

    /* renamed from: g */
    int f35742g;

    /* renamed from: h */
    int f35743h;

    /* renamed from: i */
    String f35744i = "";

    /* renamed from: j */
    String f35745j = "UNKNOWN";

    /* renamed from: k */
    ConnectivityStatus f35746k;

    /* renamed from: l */
    ConnectivityStatusSource f35747l;

    /* renamed from: m */
    List<ConnStat> f35748m = new ArrayList();

    public int getId() {
        return this.f35738c;
    }

    public int getStatus() {
        return this.f35746k.getValue();
    }

    public String getErrsPack() {
        return this.f35744i;
    }

    public int getSource() {
        return this.f35747l.getValue();
    }

    public String getTaskTime() {
        StringBuilder sb = new StringBuilder();
        sb.append(Const.jaLeft);
        String str = "0";
        sb.append(this.f35736a > 0 ? f35735n.format(new Date(this.f35736a)) : str);
        sb.append(", ");
        if (this.f35737b > 0) {
            str = f35735n.format(new Date(this.f35737b));
        }
        sb.append(str);
        sb.append(Const.jaRight);
        return sb.toString();
    }

    /* renamed from: a */
    static ConnectivityStatistics m25301a(Config config, List<ConnStat> list, String str, long j) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ConnectivityStatistics connectivityStatistics = new ConnectivityStatistics();
        connectivityStatistics.f35738c = C12166b.m25330a();
        connectivityStatistics.f35741f = list.size();
        connectivityStatistics.f35736a = j;
        connectivityStatistics.f35737b = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = list.get(0).errno;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        for (ConnStat next : list) {
            int i5 = next.errno;
            sb.append(i5);
            sb.append(",");
            if (i5 != i2 && !z) {
                z = true;
            }
            if (next.success) {
                i3++;
                i4 += next.cost;
            }
            i2 = i5;
        }
        if (z) {
            connectivityStatistics.f35744i = sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            connectivityStatistics.f35744i = String.valueOf(i2);
        }
        double d = (double) i3;
        connectivityStatistics.f35739d = ((double) Math.round((d * 100.0d) / ((double) list.size()))) / 100.0d;
        connectivityStatistics.f35740e = i3 != 0 ? ((double) Math.round((((double) i4) * 100.0d) / d)) / 100.0d : 0.0d;
        if (connectivityStatistics.f35739d > 0.0d) {
            connectivityStatistics.f35746k = ConnectivityStatus.REACHABLE;
        } else {
            connectivityStatistics.f35746k = ConnectivityStatus.UNREACHABLE;
        }
        connectivityStatistics.f35747l = ConnectivityStatusSource.TCP_CONNECT;
        connectivityStatistics.f35748m.addAll(list);
        connectivityStatistics.f35742g = config.f35714a;
        connectivityStatistics.f35743h = config.f35715b;
        connectivityStatistics.f35745j = str;
        m25304a(config.f35717d, connectivityStatistics);
        return connectivityStatistics;
    }

    /* renamed from: a */
    static ConnectivityStatistics m25302a(String str) {
        ConnectivityStatistics connectivityStatistics = new ConnectivityStatistics();
        connectivityStatistics.f35738c = C12166b.m25330a();
        connectivityStatistics.f35746k = ConnectivityStatus.UNKNOWN;
        connectivityStatistics.f35747l = ConnectivityStatusSource.UNKNOWN;
        connectivityStatistics.f35745j = str;
        connectivityStatistics.f35736a = System.currentTimeMillis();
        connectivityStatistics.f35737b = System.currentTimeMillis();
        return connectivityStatistics;
    }

    /* renamed from: a */
    static ConnectivityStatistics m25300a(Config config) {
        ConnectivityStatistics connectivityStatistics = new ConnectivityStatistics();
        connectivityStatistics.f35738c = C12166b.m25330a();
        connectivityStatistics.f35746k = ConnectivityStatus.REACHABLE;
        connectivityStatistics.f35747l = ConnectivityStatusSource.REQUEST_SUCCESS;
        connectivityStatistics.f35742g = config.f35714a;
        connectivityStatistics.f35743h = config.f35715b;
        connectivityStatistics.f35736a = System.currentTimeMillis();
        connectivityStatistics.f35737b = System.currentTimeMillis();
        m25304a(config.f35717d, connectivityStatistics);
        return connectivityStatistics;
    }

    /* renamed from: a */
    static ConnectivityStatistics m25303a(boolean z, Config config, String str) {
        ConnectivityStatistics connectivityStatistics = new ConnectivityStatistics();
        connectivityStatistics.f35738c = C12166b.m25330a();
        connectivityStatistics.f35746k = z ? ConnectivityStatus.REACHABLE : ConnectivityStatus.UNREACHABLE;
        connectivityStatistics.f35747l = ConnectivityStatusSource.NETWORK_CHANGED;
        connectivityStatistics.f35745j = str;
        connectivityStatistics.f35736a = System.currentTimeMillis();
        connectivityStatistics.f35737b = System.currentTimeMillis();
        connectivityStatistics.f35742g = config.f35714a;
        connectivityStatistics.f35743h = config.f35715b;
        m25304a(config.f35717d, connectivityStatistics);
        return connectivityStatistics;
    }

    public String toString() {
        return "ConnectivityStatistics{id = " + this.f35738c + ", version = " + this.f35742g + ", confVersion = " + this.f35743h + ", time = " + getTaskTime() + ", net = " + this.f35745j + ", taskCount = " + this.f35741f + ", succRate = " + this.f35739d + ", averCost = " + this.f35740e + ", errsPack = " + this.f35744i + ", details = " + this.f35748m.toString() + "}";
    }

    /* renamed from: a */
    private static void m25304a(double d, ConnectivityStatistics connectivityStatistics) {
        if (((double) new Random().nextFloat()) < d) {
            OmegaSDKAdapter.trackEvent("net_connectivity", connectivityStatistics.mo91458a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, Object> mo91458a() {
        HashMap hashMap = new HashMap();
        hashMap.put(RavenKey.TYPE, getTaskTime());
        hashMap.put("id", Integer.valueOf(this.f35738c));
        hashMap.put("ver", Integer.valueOf(this.f35742g));
        hashMap.put("conf_ver", Integer.valueOf(this.f35743h));
        hashMap.put("net", this.f35745j);
        hashMap.put("status", Integer.valueOf(this.f35746k.getValue()));
        hashMap.put("status_source", Integer.valueOf(this.f35747l.getValue()));
        if (this.f35747l == ConnectivityStatusSource.TCP_CONNECT) {
            hashMap.put("task_count", Integer.valueOf(this.f35741f));
            hashMap.put("succ_rate", Double.valueOf(this.f35739d));
            hashMap.put("avg_delay", Double.valueOf(this.f35740e));
            hashMap.put("errs_pack", this.f35744i);
            JSONArray jSONArray = new JSONArray();
            for (ConnStat json : this.f35748m) {
                JSONObject json2 = json.toJson();
                if (json2 != null) {
                    jSONArray.put(json2);
                }
            }
            hashMap.put("l", jSONArray.toString());
        }
        return hashMap;
    }
}
