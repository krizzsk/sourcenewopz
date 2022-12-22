package atd.p043r;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.r.b */
public class C1153b implements C1050b {
    /* renamed from: b */
    public Integer mo13780a(Context context) throws C1051c {
        int i = Build.VERSION.SDK_INT;
        if (i < 17 || i >= 26) {
            throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
        try {
            return Integer.valueOf(Settings.Global.getInt(context.getContentResolver(), C1172a.m764a(-34385961503406L)));
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-34364486666926L);
    }
}
