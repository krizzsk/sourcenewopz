package com.didi.payment.creditcard.base.binrule;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.creditcard.base.binrule.CardBin;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class ChinaCardBinRule implements ICardBinRule {

    /* renamed from: a */
    private List<CardBin> f30274a;

    public ChinaCardBinRule(Context context, String str) {
        m21170a(str);
    }

    /* renamed from: a */
    private void m21170a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f30274a = m21174d(m21173c(str));
        }
    }

    public int getCardOrg(String str) {
        CardBin b = m21172b(str);
        if (b == null) {
            return 0;
        }
        return b.f61866org;
    }

    public int getCardType(String str) {
        CardBin b = m21172b(str);
        if (b == null) {
            return 0;
        }
        return b.type;
    }

    public boolean isValid(String str) {
        return m21172b(str) != null;
    }

    /* renamed from: b */
    private CardBin m21172b(String str) {
        if (!TextUtils.isEmpty(str) && this.f30274a != null) {
            String replaceAll = str.trim().replaceAll(" ", "");
            int min = Math.min(replaceAll.length(), 6);
            int i = 0;
            try {
                int parseInt = Integer.parseInt(replaceAll.substring(0, min));
                CardBin cardBin = null;
                int i2 = 0;
                for (CardBin next : this.f30274a) {
                    if (next.range != null) {
                        for (CardBin.Range next2 : next.range) {
                            int a = m21167a(next2.start, min);
                            int b = m21171b(next2.end, min);
                            if (parseInt >= a && parseInt <= b) {
                                if (m21168a((long) next2.start) > i2) {
                                    i2 = m21168a((long) next2.start);
                                    cardBin = next;
                                }
                                i++;
                            }
                        }
                    }
                }
                if (i == 1 || min >= 6) {
                    return cardBin;
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private int m21167a(int i, int i2) {
        double pow;
        int a = m21168a((long) i);
        if (a < i2) {
            pow = ((double) i) * Math.pow(10.0d, (double) (i2 - a));
        } else if (a <= i2) {
            return i;
        } else {
            pow = ((double) i) / Math.pow(10.0d, (double) (a - i2));
        }
        return (int) pow;
    }

    /* renamed from: b */
    private int m21171b(int i, int i2) {
        int a = m21168a((long) i);
        if (a < i2) {
            return ((i + 1) * ((int) Math.pow(10.0d, (double) (i2 - a)))) - 1;
        }
        return a > i2 ? (int) (((double) i) / Math.pow(10.0d, (double) (a - i2))) : i;
    }

    /* renamed from: a */
    private static int m21168a(long j) {
        if (j <= 0) {
            j = -j;
        }
        return String.valueOf(j).length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[SYNTHETIC, Splitter:B:26:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A[SYNTHETIC, Splitter:B:32:0x0053] */
    @java.lang.Deprecated
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m21169a(android.content.Context r5, java.lang.String r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.base.binrule.ChinaCardBinRule.m21169a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    private String m21173c(String str) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(str);
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return null;
        }
        return (String) experiment.getParam("bin", "");
    }

    /* renamed from: d */
    private List<CardBin> m21174d(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<CardBin>>() {
        }.getType());
    }
}
