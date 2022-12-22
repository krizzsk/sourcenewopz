package atd.p048u;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.u.a */
public class C1177a implements C1050b {
    /* renamed from: b */
    public Long mo13780a(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 18) {
            return Long.valueOf(new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes());
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-35940739664558L);
    }
}
