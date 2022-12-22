package atd.p049v;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.v.j */
public final class C1190j extends C1179a0 {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-36155488029358L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Boolean mo13785c(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 23) {
            return Boolean.valueOf(mo13938d(context).isWorldPhone());
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
