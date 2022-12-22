package atd.p043r;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.p025i.C1051c;
import atd.p041q.C1132a;

/* renamed from: atd.r.a */
public class C1151a extends C1132a {

    /* renamed from: atd.r.a$a */
    static /* synthetic */ class C1152a {

        /* renamed from: a */
        static final /* synthetic */ int[] f373a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                atd.q.a$a[] r0 = atd.p041q.C1132a.C1133a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f373a = r0
                atd.q.a$a r1 = atd.p041q.C1132a.C1133a.INTEGER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f373a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.q.a$a r1 = atd.p041q.C1132a.C1133a.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f373a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atd.q.a$a r1 = atd.p041q.C1132a.C1133a.LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f373a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atd.q.a$a r1 = atd.p041q.C1132a.C1133a.STRING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.p043r.C1151a.C1152a.<clinit>():void");
        }
    }

    public C1151a(String str, String str2) {
        super(str, str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo13868b(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                int i = C1152a.f373a[mo13872f().ordinal()];
                if (i == 1) {
                    return Integer.valueOf(Settings.Global.getInt(context.getContentResolver(), mo13871e()));
                }
                if (i == 2) {
                    return Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), mo13871e()));
                }
                if (i != 3) {
                    return Settings.Global.getString(context.getContentResolver(), mo13871e());
                }
                return Long.valueOf(Settings.Global.getLong(context.getContentResolver(), mo13871e()));
            } catch (Settings.SettingNotFoundException unused) {
                return null;
            }
        } else {
            throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
    }
}
