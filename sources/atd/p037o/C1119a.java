package atd.p037o;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1050b;
import atd.p046s0.C1172a;

/* renamed from: atd.o.a */
public class C1119a implements C1050b {
    /* renamed from: b */
    public Integer mo13780a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Integer.valueOf(context.getResources().getConfiguration().getLocales().size());
        }
        return 1;
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-34123968498350L);
    }
}
