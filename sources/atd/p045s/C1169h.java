package atd.p045s;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.p025i.C1050b;
import atd.p025i.C1051c;

/* renamed from: atd.s.h */
public class C1169h implements C1050b {
    /* renamed from: a */
    public String mo13781a() {
        return "A067";
    }

    /* renamed from: b */
    public Integer mo13780a(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT < 26) {
            try {
                return Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), "speak_password"));
            } catch (Settings.SettingNotFoundException unused) {
                return null;
            }
        } else {
            throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
    }
}
