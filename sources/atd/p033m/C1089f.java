package atd.p033m;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import atd.p025i.C1050b;
import atd.p046s0.C1172a;
import java.util.Locale;

/* renamed from: atd.m.f */
public final class C1089f implements C1050b {
    static {
        C1172a.m764a(-32659384650414L);
    }

    /* renamed from: b */
    public String mo13780a(Context context) {
        Locale locale;
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            locale = configuration.getLocales().get(0);
        } else {
            locale = configuration.locale;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return locale.toLanguageTag();
        }
        return String.format(Locale.ENGLISH, C1172a.m764a(-32633614846638L), new Object[]{locale.getLanguage(), locale.getCountry()});
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-32612140010158L);
    }
}
