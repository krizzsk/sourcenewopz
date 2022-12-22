package com.didi.dimina.container.debug;

import android.text.TextUtils;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.RemoteBundleMangerStrategy;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.starbox.module.StarBoxDockerActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONArray;
import org.json.JSONObject;

public class DevModeManager {

    /* renamed from: a */
    private static final String f16787a = "DevModeManager";

    /* renamed from: b */
    private static final String f16788b = "dev_mode_key_gift_";

    /* renamed from: c */
    private static final String f16789c = "dev_mode_key_dev_";

    /* renamed from: d */
    private static final String f16790d = "dev_mode_key_ip_";

    /* renamed from: e */
    private static final String f16791e = "dev_mode_key_gift_giftUrl_";

    /* renamed from: f */
    private final String f16792f;

    /* renamed from: g */
    private BundleManagerStrategy f16793g = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DevMode {
        public static final String DEV_GIFT = "dev_mode_gift";
        public static final String DEV_IP = "dev_mode_ip";
    }

    public DevModeManager(String str) {
        this.f16792f = str;
    }

    public void setDevMode4GIFT(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f16788b + this.f16792f, str);
    }

    public void setDevMode4GIFTURL(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f16791e + this.f16792f, str);
    }

    public void setDevMode4IP(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f16790d + this.f16792f, str);
    }

    public void setDevMode(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(f16789c + this.f16792f, str);
    }

    public void resetDevMode() {
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.remove(f16789c + this.f16792f);
    }

    public BundleManagerStrategy getBundleManagerStrategy(BundleManagerStrategy bundleManagerStrategy) {
        if (this.f16793g == null) {
            MMKVUtil instance = MMKVUtil.getInstance();
            String str = (String) instance.get(f16789c + this.f16792f, "");
            if (TextUtils.equals(str, DevMode.DEV_IP)) {
                MMKVUtil instance2 = MMKVUtil.getInstance();
                this.f16793g = new RemoteBundleMangerStrategy((String) instance2.get(f16790d + this.f16792f, ""));
            } else if (TextUtils.equals(str, DevMode.DEV_GIFT)) {
                MMKVUtil instance3 = MMKVUtil.getInstance();
                this.f16793g = new RemoteBundleMangerStrategy((String) instance3.get(f16788b + this.f16792f, ""));
            } else {
                this.f16793g = bundleManagerStrategy;
            }
        }
        return this.f16793g;
    }

    public JSONArray getDevModeList() {
        JSONArray jSONArray = new JSONArray();
        MMKVUtil instance = MMKVUtil.getInstance();
        String str = (String) instance.get(f16789c + this.f16792f, "");
        JSONObject jSONObject = new JSONObject();
        MMKVUtil instance2 = MMKVUtil.getInstance();
        String str2 = (String) instance2.get(f16788b + this.f16792f, "");
        MMKVUtil instance3 = MMKVUtil.getInstance();
        JSONUtil.put(jSONObject, "enable", !TextUtils.isEmpty(str2));
        JSONUtil.put(jSONObject, "url", (Object) str2);
        JSONUtil.put(jSONObject, "giftUrl", (Object) (String) instance3.get(f16791e + this.f16792f, ""));
        JSONUtil.put(jSONObject, "name", (Object) "预览模式");
        JSONUtil.put(jSONObject, "dev", (Object) StarBoxDockerActivity.VALUE_DEV_MODE_GIFT);
        JSONUtil.put(jSONObject, "select", TextUtils.equals(str, DevMode.DEV_GIFT));
        JSONUtil.put(jSONObject, "needLaunch", true);
        JSONUtil.put(jSONArray, jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        MMKVUtil instance4 = MMKVUtil.getInstance();
        String str3 = (String) instance4.get(f16790d + this.f16792f, "");
        JSONUtil.put(jSONObject2, "enable", TextUtils.isEmpty(str3) ^ true);
        JSONUtil.put(jSONObject2, "url", (Object) str3);
        JSONUtil.put(jSONObject2, "name", (Object) "ip直连模式");
        JSONUtil.put(jSONObject2, "dev", (Object) "ip");
        JSONUtil.put(jSONObject2, "select", TextUtils.equals(str, DevMode.DEV_IP));
        JSONUtil.put(jSONObject2, "needLaunch", true);
        JSONUtil.put(jSONArray, jSONObject2);
        boolean z = TextUtils.equals(str, DevMode.DEV_GIFT) || TextUtils.equals(str, DevMode.DEV_IP);
        JSONObject jSONObject3 = new JSONObject();
        JSONUtil.put(jSONObject3, "enable", true);
        JSONUtil.put(jSONObject3, "url", (Object) "");
        JSONUtil.put(jSONObject3, "name", (Object) "默认模式");
        JSONUtil.put(jSONObject3, "dev", (Object) "none");
        JSONUtil.put(jSONObject3, "select", !z);
        JSONUtil.put(jSONObject3, "needLaunch", false);
        JSONUtil.put(jSONArray, jSONObject3);
        return jSONArray;
    }

    public static boolean isGiftDevModel(String str) {
        MMKVUtil instance = MMKVUtil.getInstance();
        return TextUtils.equals((String) instance.get(f16789c + str, ""), DevMode.DEV_GIFT);
    }
}
