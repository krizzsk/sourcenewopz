package com.didi.payment.creditcard.base.binrule;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BrazilCardBinRule implements ICardBinRule {

    /* renamed from: a */
    private static String f30268a;

    /* renamed from: b */
    private HashMap<String, ApolloCardBinInfo> f30269b = new HashMap<>(128);

    /* renamed from: c */
    private String f30270c;

    public BrazilCardBinRule(Context context, String str) {
        this.f30270c = str;
        m21165a(this.f30269b, m21163a(f30268a));
    }

    /* renamed from: a */
    private void m21165a(HashMap<String, ApolloCardBinInfo> hashMap, JSONObject jSONObject) {
        if (hashMap != null && jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        m21166a(hashMap, jSONObject.optJSONObject(next), Integer.parseInt(next.trim()));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m21166a(HashMap<String, ApolloCardBinInfo> hashMap, JSONObject jSONObject, int i) throws JSONException {
        if (jSONObject != null) {
            m21164a(hashMap, jSONObject.optJSONArray("1"), 2, i);
            m21164a(hashMap, jSONObject.optJSONArray("3"), 3, i);
            m21164a(hashMap, jSONObject.optJSONArray("2"), 1, i);
        }
    }

    /* renamed from: a */
    private void m21164a(HashMap<String, ApolloCardBinInfo> hashMap, JSONArray jSONArray, int i, int i2) throws JSONException {
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                int i4 = jSONArray.getInt(i3);
                ApolloCardBinInfo apolloCardBinInfo = new ApolloCardBinInfo();
                apolloCardBinInfo.cardNo = i4;
                apolloCardBinInfo.cardType = i;
                apolloCardBinInfo.cardOrg = i2;
                hashMap.put(String.valueOf(apolloCardBinInfo.cardNo), apolloCardBinInfo);
            }
        }
    }

    /* renamed from: a */
    private JSONObject m21163a(String str) {
        IToggle toggle = Apollo.getToggle(this.f30270c);
        JSONObject jSONObject = null;
        if (toggle != null && toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            if (experiment == null) {
                return null;
            }
            String str2 = (String) experiment.getParam("bin", "");
            if (str2 != null && !str2.isEmpty()) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (jSONObject != null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[SYNTHETIC, Splitter:B:26:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A[SYNTHETIC, Splitter:B:32:0x0053] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m21162a(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            if (r6 == 0) goto L_0x005c
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x005c
        L_0x000b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x0042 }
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ IOException -> 0x0042 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0042 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0042 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0042 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0042 }
        L_0x0023:
            java.lang.String r5 = r6.readLine()     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            if (r5 == 0) goto L_0x002d
            r1.append(r5)     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            goto L_0x0023
        L_0x002d:
            java.lang.String r5 = r1.toString()     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            r6.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0039:
            return r5
        L_0x003a:
            r5 = move-exception
            r2 = r6
            goto L_0x0051
        L_0x003d:
            r5 = move-exception
            r2 = r6
            goto L_0x0043
        L_0x0040:
            r5 = move-exception
            goto L_0x0051
        L_0x0042:
            r5 = move-exception
        L_0x0043:
            r5.printStackTrace()     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0050
            r2.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0050:
            return r0
        L_0x0051:
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005b:
            throw r5
        L_0x005c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.base.binrule.BrazilCardBinRule.m21162a(android.content.Context, java.lang.String):java.lang.String");
    }

    public ApolloCardBinInfo getCardBinInfo(int i) {
        String valueOf = String.valueOf(i);
        if (valueOf.length() < 6) {
            return null;
        }
        return this.f30269b.get(valueOf);
    }

    public ApolloCardBinInfo getCardBinInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String replace = str.trim().replace(" ", "");
        if (replace.length() < 6) {
            return null;
        }
        return this.f30269b.get(replace.substring(0, 6));
    }

    public int getCardOrg(String str) {
        ApolloCardBinInfo cardBinInfo;
        if (!TextUtils.isEmpty(str) && (cardBinInfo = getCardBinInfo(str)) != null) {
            return cardBinInfo.cardOrg;
        }
        return 0;
    }

    public int getCardType(String str) {
        ApolloCardBinInfo cardBinInfo;
        if (!TextUtils.isEmpty(str) && (cardBinInfo = getCardBinInfo(str)) != null) {
            return cardBinInfo.cardType;
        }
        return 0;
    }

    public boolean isValid(String str) {
        if (!TextUtils.isEmpty(str) && getCardBinInfo(str) != null) {
            return true;
        }
        return false;
    }

    public static final class ApolloCardBinInfo {
        public int cardNo;
        public int cardOrg;
        public int cardType;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            ApolloCardBinInfo apolloCardBinInfo = (ApolloCardBinInfo) obj;
            return this.cardNo == apolloCardBinInfo.cardNo && this.cardOrg == apolloCardBinInfo.cardOrg && this.cardType == apolloCardBinInfo.cardType;
        }

        public int hashCode() {
            int i = this.cardType;
            return (((((i * 31) + i) * 31) + this.cardOrg) * 31) + this.cardNo;
        }
    }
}
