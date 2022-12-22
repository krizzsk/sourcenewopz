package atd.p039p;

import android.content.Context;
import android.content.pm.FeatureInfo;
import atd.p046s0.C1172a;

/* renamed from: atd.p.d */
public class C1124d extends C1121a {
    /* renamed from: c */
    public Integer mo13780a(Context context) {
        FeatureInfo[] systemAvailableFeatures = mo13852b(context).getSystemAvailableFeatures();
        return Integer.valueOf(systemAvailableFeatures != null ? systemAvailableFeatures.length : 0);
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-34188393007790L);
    }
}
