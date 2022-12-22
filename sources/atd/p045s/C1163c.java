package atd.p045s;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.p025i.C1050b;
import atd.p046s0.C1172a;

/* renamed from: atd.s.c */
public class C1163c implements C1050b {
    /* renamed from: b */
    public Integer mo13780a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return Integer.valueOf(Settings.Global.getInt(contentResolver, C1172a.m764a(-34905652546222L)));
            }
            return Integer.valueOf(Settings.Secure.getInt(contentResolver, C1172a.m764a(-34987256924846L)));
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-34884177709742L);
    }
}
