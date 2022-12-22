package atd.p045s;

import android.content.Context;
import android.provider.Settings;
import atd.p025i.C1050b;
import atd.p046s0.C1172a;

/* renamed from: atd.s.d */
public class C1164d implements C1050b {
    /* renamed from: b */
    public Integer mo13780a(Context context) {
        try {
            return Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), C1172a.m764a(-35090336139950L)));
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-35068861303470L);
    }
}
