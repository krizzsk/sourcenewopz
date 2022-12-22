package com.didi.sdk.connectivity;

import android.util.Log;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import didinet.ApolloAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.core.runtime.AgentOptions;
import org.json.JSONArray;
import org.json.JSONObject;

class Config {

    /* renamed from: a */
    int f35714a;

    /* renamed from: b */
    int f35715b;

    /* renamed from: c */
    int f35716c;

    /* renamed from: d */
    double f35717d;

    /* renamed from: e */
    int f35718e;

    /* renamed from: f */
    int f35719f = -1;

    /* renamed from: g */
    int f35720g = -1;

    /* renamed from: h */
    int f35721h;

    /* renamed from: i */
    List<Item> f35722i = Collections.emptyList();

    Config() {
    }

    /* renamed from: a */
    static Config m25293a(ApolloAPI.Experiment experiment) {
        try {
            Config config = new Config();
            int intValue = ((Integer) experiment.getParam(RavenKey.VERSION, 0)).intValue();
            config.f35714a = intValue;
            if (intValue != 1) {
                return null;
            }
            config.f35715b = ((Integer) experiment.getParam("conf_ver", 0)).intValue();
            config.f35716c = ((Integer) experiment.getParam("timeout", 5)).intValue();
            config.f35718e = ((Integer) experiment.getParam("min_interval", 10)).intValue();
            config.f35717d = ((Double) experiment.getParam("report_rate", Double.valueOf(0.5d))).doubleValue();
            config.f35719f = ((Integer) experiment.getParam("ping_cnt", -1)).intValue();
            config.f35720g = ((Integer) experiment.getParam("tracert_ttl", -1)).intValue();
            config.f35721h = ((Integer) experiment.getParam("tracert_timeout", -1)).intValue();
            List<Item> parse = Item.parse(new JSONArray((String) experiment.getParam("l", "")));
            if (parse != null) {
                for (Item next : parse) {
                    if (next.timeout <= 0) {
                        next.timeout = config.f35716c;
                    }
                }
                config.f35722i = new ArrayList(parse);
                return config;
            }
            return null;
        } catch (Throwable th) {
            SystemUtils.log(3, "didi-connectivity", Log.getStackTraceString(th), (Throwable) null, "com.didi.sdk.connectivity.Config", 100);
        }
    }

    static class Item {
        String host;

        /* renamed from: ip */
        String f35723ip;
        int pingCnt;
        int port;
        int timeout;
        int trMaxTTL;
        int trTimeout;

        @Deprecated
        Item(String str, int i, int i2) {
            this(str, i, i2, -1, -1, -1);
        }

        Item(String str, int i, int i2, int i3, int i4, int i5) {
            this.host = str;
            this.f35723ip = str;
            this.port = i;
            this.timeout = i2;
            this.pingCnt = i3;
            this.trMaxTTL = i4;
            this.trTimeout = i5;
        }

        static List<Item> parse(JSONArray jSONArray) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(parse(jSONArray.optJSONObject(i)));
                }
                return arrayList;
            } catch (Throwable th) {
                SystemUtils.log(3, "connectivity", Log.getStackTraceString(th), (Throwable) null, "com.didi.sdk.connectivity.Config$Item", 156);
                return null;
            }
        }

        static Item parse(JSONObject jSONObject) {
            try {
                return new Item(jSONObject.getString("host"), jSONObject.getInt(AgentOptions.PORT), jSONObject.optInt("timeout"), jSONObject.optInt("ping_cnt", -1), jSONObject.optInt("tracert_ttl", -1), jSONObject.optInt("tracert_timeout", -1));
            } catch (Exception e) {
                SystemUtils.log(3, "connectivity", Log.getStackTraceString(e), (Throwable) null, "com.didi.sdk.connectivity.Config$Item", 170);
                return null;
            }
        }

        public String toString() {
            return "Item{host='" + this.host + '\'' + ", ip='" + this.f35723ip + '\'' + ", port=" + this.port + ", timeout=" + this.timeout + ", pingCnt=" + this.pingCnt + ", trMaxTTL=" + this.trMaxTTL + ", trTimeout=" + this.trTimeout + '}';
        }
    }

    public String toString() {
        return "Config{version=" + this.f35714a + ", confVersion=" + this.f35715b + ", timeout=" + this.f35716c + ", reportRate=" + this.f35717d + ", minInterval=" + this.f35718e + ", pingCnt=" + this.f35719f + ", trMaxTTL=" + this.f35720g + ", trTimeout=" + this.f35721h + ", items=" + this.f35722i + '}';
    }
}
