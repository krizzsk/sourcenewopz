package atd.p044r0;

import atd.p046s0.C1172a;
import atd.p052y.C1223a;
import com.adyen.threeds2.exception.InvalidInputException;
import java.util.Locale;

/* renamed from: atd.r0.c */
public final class C1156c {
    static {
        C1172a.m764a(-727881445886638L);
    }

    /* renamed from: a */
    private static boolean m725a(Locale locale) {
        return (locale == null || locale.getLanguage() == null || locale.getCountry() == null) ? false : true;
    }

    /* renamed from: b */
    public static void m726b(String str) throws InvalidInputException {
        if (str != null && !m725a(m724a(str))) {
            throw C1223a.LOCALE.mo13978a();
        }
    }

    /* renamed from: a */
    private static Locale m724a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(C1172a.m764a(-727872855952046L));
        int length = split.length;
        if (length == 1) {
            return new Locale(split[0]);
        }
        if (length == 2) {
            return new Locale(split[0], split[1]);
        }
        if (length != 3) {
            return null;
        }
        return new Locale(split[0], split[1], split[2]);
    }
}
