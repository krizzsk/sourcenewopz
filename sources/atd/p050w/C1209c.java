package atd.p050w;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.w.c */
public final class C1209c extends C1207a {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-36924287175342L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Boolean mo13785c(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 21) {
            return Boolean.valueOf(mo13966e(context).is5GHzBandSupported());
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
