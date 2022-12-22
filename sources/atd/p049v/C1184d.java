package atd.p049v;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.v.d */
public final class C1184d extends C1200t {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-36026639010478L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo13785c(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 26) {
            return mo13938d(context).getImei();
        }
        return mo13938d(context).getDeviceId();
    }
}
