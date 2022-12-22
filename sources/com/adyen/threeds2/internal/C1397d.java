package com.adyen.threeds2.internal;

import android.text.TextUtils;
import atd.p023h.C1037a;
import atd.p044r0.C1160g;
import atd.p046s0.C1172a;
import atd.p052y.C1223a;

/* renamed from: com.adyen.threeds2.internal.d */
public enum C1397d {
    V2_1_0(C1172a.m764a(-236676532910L), C1037a.V1_4),
    V2_2_0(C1172a.m764a(-356935617198L), C1037a.V1_4);
    
    private final C1037a mDataVersion;
    private final String mVersion;

    private C1397d(String str, C1037a aVar) {
        this.mVersion = str;
        this.mDataVersion = aVar;
    }

    /* renamed from: a */
    public static C1397d[] m1100a() {
        return values();
    }

    /* renamed from: b */
    public static C1397d m1101b(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (C1397d dVar : values()) {
                if (dVar.mo14848c().equals(str)) {
                    return dVar;
                }
            }
        }
        throw C1223a.MESSAGE_VERSION.mo13978a();
    }

    /* renamed from: c */
    public String mo14848c() {
        return m1099a(this.mVersion);
    }

    public String toString() {
        return mo14848c();
    }

    /* renamed from: a */
    private String m1099a(String str) {
        return C1160g.m734a(str);
    }

    /* renamed from: b */
    public C1037a mo14847b() {
        return this.mDataVersion;
    }
}
