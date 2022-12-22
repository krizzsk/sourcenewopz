package com.didi.sdk.monitor;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class PubSIDManager {

    /* renamed from: a */
    private static final String f36845a = PubSIDManager.class.getSimpleName();

    /* renamed from: b */
    private static final Map<String, Object> f36846b = new HashMap();

    private PubSIDManager() {
    }

    private static final class Singleton {
        /* access modifiers changed from: private */
        public static final PubSIDManager sInstance = new PubSIDManager();

        private Singleton() {
        }
    }

    public static PubSIDManager getInstance() {
        return Singleton.sInstance;
    }

    public void setPubSID(String str, Object obj) {
        f36846b.put(str, obj);
        String str2 = f36845a;
        SystemUtils.log(3, str2, "setPubSID: pubSID " + m26096a(), (Throwable) null, "com.didi.sdk.monitor.PubSIDManager", 48);
        OmegaSDK.putGlobalAttr("pub_sid", m26096a());
    }

    public void setPubSID(Map<String, Object> map) {
        f36846b.putAll(map);
        String str = f36845a;
        SystemUtils.log(3, str, "setPubSID: pubSID " + m26096a(), (Throwable) null, "com.didi.sdk.monitor.PubSIDManager", 54);
        OmegaSDK.putGlobalAttr("pub_sid", m26096a());
    }

    public void removePubSID(String str, Object obj) {
        f36846b.remove(str);
        String str2 = f36845a;
        SystemUtils.log(3, str2, "removePubSID: pubSID " + m26096a(), (Throwable) null, "com.didi.sdk.monitor.PubSIDManager", 60);
        OmegaSDK.putGlobalAttr("pub_sid", m26096a());
    }

    public void removePubSID(Map<String, Object> map) {
        for (String remove : map.keySet()) {
            f36846b.remove(remove);
        }
        String str = f36845a;
        SystemUtils.log(3, str, "removePubSID: pubSID " + m26096a(), (Throwable) null, "com.didi.sdk.monitor.PubSIDManager", 69);
        OmegaSDK.putGlobalAttr("pub_sid", m26096a());
    }

    /* renamed from: a */
    private String m26096a() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : f36846b.entrySet()) {
            Object value = next.getValue();
            sb.append(((String) next.getKey()) + "=" + value + ";");
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }
}
