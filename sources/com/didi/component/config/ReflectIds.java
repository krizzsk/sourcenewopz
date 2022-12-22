package com.didi.component.config;

import android.content.Context;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReflectIds {

    /* renamed from: a */
    private static final String f12617a = "components/components";

    /* renamed from: b */
    private Map<Integer, Reflect> f12618b;

    private ReflectIds(Context context) {
        this.f12618b = Collections.synchronizedMap(new HashMap());
        m8590a(context);
    }

    private static final class Holder {
        private static volatile ReflectIds sInstance;

        private Holder() {
        }

        static ReflectIds newInstance(Context context) {
            if (sInstance == null) {
                synchronized (Holder.class) {
                    if (sInstance == null) {
                        sInstance = new ReflectIds(context);
                    }
                }
            }
            return sInstance;
        }
    }

    public static ReflectIds get(Context context) {
        return Holder.newInstance(context);
    }

    final class Reflect {
        String name;
        String type;

        Reflect(String str, String str2) {
            this.type = str;
            this.name = str2;
        }

        /* access modifiers changed from: package-private */
        public String type() {
            return this.type;
        }

        /* access modifiers changed from: package-private */
        public String name() {
            return this.name;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0028 A[SYNTHETIC, Splitter:B:18:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[SYNTHETIC, Splitter:B:24:0x0032] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8590a(android.content.Context r4) {
        /*
            r3 = this;
            android.content.res.AssetManager r4 = r4.getAssets()
            r0 = 0
            java.lang.String r1 = "components/components"
            java.io.InputStream r4 = r4.open(r1)     // Catch:{ IOException -> 0x0021, all -> 0x001c }
            java.lang.String r0 = com.didi.component.config.util.StreamUtils.readStringFromStream(r4)     // Catch:{ IOException -> 0x001a }
            if (r4 == 0) goto L_0x002b
            r4.close()     // Catch:{ IOException -> 0x0015 }
            goto L_0x002b
        L_0x0015:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x002b
        L_0x001a:
            r1 = move-exception
            goto L_0x0023
        L_0x001c:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x0030
        L_0x0021:
            r1 = move-exception
            r4 = r0
        L_0x0023:
            r1.printStackTrace()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x002b
            r4.close()     // Catch:{ IOException -> 0x0015 }
        L_0x002b:
            r3.m8591a((java.lang.String) r0)
            return
        L_0x002f:
            r0 = move-exception
        L_0x0030:
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.config.ReflectIds.m8590a(android.content.Context):void");
    }

    /* renamed from: a */
    private void m8591a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("components");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("type");
                    String optString2 = optJSONObject.optString("name");
                    int optInt = optJSONObject.optInt("id");
                    this.f12618b.put(Integer.valueOf(optInt), new Reflect(optString, optString2));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String type(int i) {
        Map<Integer, Reflect> map = this.f12618b;
        return (map == null || map.size() <= 0 || !this.f12618b.containsKey(Integer.valueOf(i))) ? "" : this.f12618b.get(Integer.valueOf(i)).type();
    }

    public String name(int i) {
        Map<Integer, Reflect> map = this.f12618b;
        return (map == null || map.size() <= 0 || !this.f12618b.containsKey(Integer.valueOf(i))) ? "" : this.f12618b.get(Integer.valueOf(i)).name();
    }
}
