package didihttp.internal.trace;

import android.text.TextUtils;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.raven.config.RavenKey;
import didinet.ApolloAPI;
import didinet.ApolloKeySwitcher;
import didinet.NetEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogStrategy {

    /* renamed from: a */
    private boolean f56908a;

    /* renamed from: b */
    private List<URLItem> f56909b;

    /* renamed from: a */
    private boolean m40861a(int i) {
        return i == 2;
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static LogStrategy INSTANCE = new LogStrategy();

        private SingletonHolder() {
        }
    }

    public static LogStrategy getStrategy() {
        return SingletonHolder.INSTANCE;
    }

    private LogStrategy() {
        this.f56909b = new ArrayList();
    }

    public void readFromApollo() {
        if (!this.f56908a) {
            ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
            String httpLogKey = ApolloKeySwitcher.getInstance().getHttpLogKey();
            if (!TextUtils.isEmpty(httpLogKey)) {
                boolean allow = apolloAPI.getToggle(httpLogKey).allow();
                this.f56908a = allow;
                if (allow) {
                    m40863b((String) apolloAPI.getToggle(httpLogKey).getExperiment().getParam(GPageIdConstant.G_PAGE_ID_CONF, ""));
                }
            }
        }
    }

    /* renamed from: b */
    private void m40863b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (m40861a(jSONObject.optInt(RavenKey.VERSION))) {
                    m40859a(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    private void m40859a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("l");
        if (optJSONArray != null) {
            this.f56909b.clear();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    if (split.length > 1) {
                        String str = split[0];
                        try {
                            this.f56909b.add(new URLItem(str, Float.parseFloat(split[1])));
                        } catch (NumberFormatException unused) {
                        }
                    } else {
                        this.f56909b.add(new URLItem(optString));
                    }
                }
            }
        }
    }

    public boolean isLogOpen(String str) {
        if (this.f56908a) {
            return m40864c(m40858a(str));
        }
        return false;
    }

    /* renamed from: c */
    private boolean m40864c(String str) {
        for (URLItem next : this.f56909b) {
            if (m40862a(str, next.url)) {
                return m40860a(next.rate);
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m40860a(float f) {
        return new Random().nextFloat() < f;
    }

    /* renamed from: a */
    static String m40858a(String str) {
        int indexOf = str.indexOf(63);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }

    /* renamed from: a */
    private static boolean m40862a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!str.equals("https://" + str2)) {
            if (str.equals("http://" + str2)) {
                return true;
            }
            return false;
        }
        return true;
    }

    static class URLItem {
        float rate;
        String url;

        public URLItem(String str, float f) {
            this.url = str;
            this.rate = f;
        }

        public URLItem(String str) {
            this.url = str;
            this.rate = 1.0f;
        }
    }
}
