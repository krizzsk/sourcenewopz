package com.didi.sdk.fusionbridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.onehybrid.util.C10393Util;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.store.WebConfigStore;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FusionUrlRecorder {

    /* renamed from: a */
    private static final String f35968a = "tone_p_x_fusion_user_link_path";

    /* renamed from: b */
    private static final String f35969b = "access_path";

    /* renamed from: c */
    private static final String f35970c = "extern_count";

    /* renamed from: d */
    private static final int f35971d = 30;

    /* renamed from: e */
    private final Context f35972e;

    /* renamed from: f */
    private final WebConfigStore f35973f;

    /* renamed from: g */
    private final LinkedList<UrlInfo> f35974g;

    /* renamed from: h */
    private int f35975h = 0;

    public FusionUrlRecorder(Context context) {
        this.f35972e = context;
        this.f35973f = WebConfigStore.getInstance();
        this.f35974g = new LinkedList<>();
    }

    public void recordUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            boolean isWhiteUrl = this.f35973f.isWhiteUrl(str, this.f35972e);
            if (!isWhiteUrl) {
                this.f35975h++;
            }
            this.f35974g.add(new UrlInfo(str, str2, isWhiteUrl));
            if (this.f35974g.size() > 30) {
                this.f35974g.remove(0);
            }
        }
    }

    public void flush() {
        if (this.f35974g.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f35974g.iterator();
            while (it.hasNext()) {
                jSONArray.put(((UrlInfo) it.next()).toJSON());
            }
            HashMap hashMap = new HashMap();
            hashMap.put(f35969b, jSONArray.toString());
            hashMap.put(f35970c, Integer.valueOf(this.f35975h));
            if (C10393Util.isApkDebug(this.f35972e)) {
                SystemUtils.log(4, "FusionUrl", hashMap.toString(), (Throwable) null, "com.didi.sdk.fusionbridge.FusionUrlRecorder", 74);
            }
            OmegaSDKAdapter.trackEvent(f35968a, (Map<String, Object>) hashMap);
        }
    }

    private class UrlInfo {
        private boolean hasToken;
        private boolean isExtern;
        private boolean isHttps;
        private String title;
        private String url;

        public UrlInfo(String str, String str2, boolean z) {
            this.title = str2;
            this.isHttps = str.startsWith("https://");
            if (str.contains("?")) {
                String[] split = str.split("\\?");
                this.url = split[0];
                if (split.length >= 2) {
                    this.hasToken = split[1].contains("token=");
                } else {
                    this.hasToken = false;
                }
            } else {
                this.url = str;
                this.hasToken = false;
            }
            this.isExtern = !z;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put("title", this.title);
                jSONObject.put("isHttps", this.isHttps);
                jSONObject.put("hasToken", this.hasToken);
                jSONObject.put("isExtern", this.isExtern);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
