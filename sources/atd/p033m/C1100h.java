package atd.p033m;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;
import java.lang.reflect.Field;
import java.util.Locale;

/* renamed from: atd.m.h */
public final class C1100h implements C1050b {
    static {
        C1172a.m764a(-33883450329774L);
    }

    /* renamed from: b */
    public String mo13780a(Context context) throws C1051c {
        Field[] fields = Build.VERSION_CODES.class.getFields();
        int length = fields.length;
        int i = 0;
        while (i < length) {
            Field field = fields[i];
            try {
                int i2 = field.getInt((Object) null);
                if (i2 == Build.VERSION.SDK_INT) {
                    return String.format(Locale.US, C1172a.m764a(-33793256016558L), new Object[]{field.getName(), Build.VERSION.RELEASE, Integer.valueOf(i2)});
                }
                i++;
            } catch (IllegalAccessException unused) {
            }
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-33771781180078L);
    }
}
