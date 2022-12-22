package atd.p049v;

import android.content.Context;
import android.telephony.TelephonyManager;
import atd.p025i.C1051c;
import atd.p025i.C1053d;
import atd.p046s0.C1172a;
import java.util.Collections;
import java.util.List;

/* renamed from: atd.v.a0 */
abstract class C1179a0 extends C1053d {
    C1179a0() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<String> mo13784b() {
        return Collections.singletonList(C1172a.m764a(-36499085413038L));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TelephonyManager mo13938d(Context context) throws C1051c {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(C1172a.m764a(-36653704235694L));
        if (telephonyManager != null) {
            return telephonyManager;
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
