package atd.p044r0;

import atd.p052y.C1223a;
import com.adyen.threeds2.exception.InvalidInputException;
import java.security.InvalidParameterException;
import java.util.UUID;

/* renamed from: atd.r0.f */
public final class C1159f {
    /* renamed from: a */
    public static void m731a(Object obj, C1223a aVar) throws InvalidInputException {
        if (obj == null) {
            throw aVar.mo13979a(new InvalidParameterException("Object is null"));
        }
    }

    /* renamed from: b */
    public static void m733b(String str, C1223a aVar) throws InvalidInputException {
        m731a((Object) str, aVar);
        try {
            if (!UUID.fromString(str).toString().equalsIgnoreCase(str)) {
                throw aVar.mo13979a(new InvalidParameterException("Value and UUID do not match"));
            }
        } catch (IllegalArgumentException unused) {
            throw aVar.mo13979a(new InvalidParameterException("Value not a UUID"));
        }
    }

    /* renamed from: a */
    public static void m732a(String str, C1223a aVar) throws InvalidInputException {
        if (str == null || str.length() == 0) {
            throw aVar.mo13979a(new InvalidParameterException("Value is empty"));
        }
    }

    /* renamed from: a */
    public static void m730a(int i, int i2, C1223a aVar) throws InvalidInputException {
        if (i < i2) {
            throw aVar.mo13978a();
        }
    }
}
