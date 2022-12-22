package atd.p023h;

import atd.p046s0.C1172a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: atd.h.a */
public enum C1037a {
    V1_1(C1172a.m764a(-19190367210158L), false),
    V1_4(C1172a.m764a(-19229021915822L), true);
    
    private final boolean mActive;
    private final String mVersion;

    private C1037a(String str, boolean z) {
        this.mVersion = str;
        this.mActive = z;
    }

    /* renamed from: a */
    public static List<C1037a> m381a() {
        ArrayList arrayList = new ArrayList();
        for (C1037a aVar : values()) {
            if (aVar.mo13770c()) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public String mo13769b() {
        return this.mVersion;
    }

    /* renamed from: c */
    public boolean mo13770c() {
        return this.mActive;
    }

    public String toString() {
        return this.mVersion;
    }
}
