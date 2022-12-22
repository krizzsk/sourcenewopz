package atd.p045s;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.s.i */
public final class C1170i implements C1050b {
    static {
        C1172a.m764a(-35515537902254L);
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-35386688883374L);
    }

    /* renamed from: a */
    public Object mo13780a(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT <= 23) {
            Class<Settings.Secure> cls = Settings.Secure.class;
            try {
                return Settings.Secure.getString(context.getContentResolver(), (String) cls.getField(C1172a.m764a(-35408163719854L)).get((Object) null));
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
