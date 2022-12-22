package atd.p045s;

import android.content.Context;
import android.provider.Settings;
import atd.p041q.C1132a;

/* renamed from: atd.s.f */
public final class C1166f extends C1132a {

    /* renamed from: atd.s.f$a */
    static /* synthetic */ class C1167a {

        /* renamed from: a */
        static final /* synthetic */ int[] f377a;

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
                f377a = r0
                atd.q.a$a r1 = atd.p041q.C1132a.C1133a.INTEGER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f377a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.q.a$a r1 = atd.p041q.C1132a.C1133a.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f377a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atd.q.a$a r1 = atd.p041q.C1132a.C1133a.LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f377a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atd.q.a$a r1 = atd.p041q.C1132a.C1133a.STRING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.p045s.C1166f.C1167a.<clinit>():void");
        }
    }

    public C1166f(String str, String str2) {
        super(str, str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo13868b(Context context) {
        try {
            int i = C1167a.f377a[mo13872f().ordinal()];
            if (i == 1) {
                return Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), mo13871e()));
            }
            if (i == 2) {
                return Float.valueOf(Settings.Secure.getFloat(context.getContentResolver(), mo13871e()));
            }
            if (i != 3) {
                return Settings.Secure.getString(context.getContentResolver(), mo13871e());
            }
            return Long.valueOf(Settings.Secure.getLong(context.getContentResolver(), mo13871e()));
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }
}
