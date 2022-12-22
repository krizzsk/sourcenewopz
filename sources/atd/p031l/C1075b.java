package atd.p031l;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.l.b */
public class C1075b implements C1050b {
    /* renamed from: b */
    public String mo13780a(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 23) {
            return Build.VERSION.SECURITY_PATCH;
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-31727376747182L);
    }
}
