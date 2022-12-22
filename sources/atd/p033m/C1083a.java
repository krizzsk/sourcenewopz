package atd.p033m;

import android.content.Context;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* renamed from: atd.m.a */
public final class C1083a implements C1050b {
    /* renamed from: b */
    public String mo13780a(Context context) throws C1051c {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
        } catch (Throwable th) {
            throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, th);
        }
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-31748851583662L);
    }
}
