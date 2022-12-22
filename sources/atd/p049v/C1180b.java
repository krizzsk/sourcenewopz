package atd.p049v;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.v.b */
public final class C1180b extends C1179a0 {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-35983689337518L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo13785c(Context context) throws C1051c {
        TelephonyManager d = mo13938d(context);
        if (Build.VERSION.SDK_INT >= 18 && d.getPhoneType() == 1) {
            return d.getGroupIdLevel1();
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
