package jumio.core;

import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.p0 */
/* compiled from: StringUtil.kt */
public final class C21374p0 {

    /* renamed from: a */
    public static final C21374p0 f59668a = new C21374p0();

    /* renamed from: a */
    public final String mo175869a(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str2, "regex");
        if (str == null) {
            return null;
        }
        String a = mo175868a(str, i);
        if (!Pattern.compile(str2).matcher(a).matches()) {
            return null;
        }
        return a;
    }

    /* renamed from: a */
    public final byte[] mo175870a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        int i2 = length - 1;
        if (i2 < 0) {
            return bArr;
        }
        while (true) {
            int i3 = i + 1;
            int i4 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i4), 16) << 4) + Character.digit(str.charAt(i4 + 1), 16));
            if (i3 > i2) {
                return bArr;
            }
            i = i3;
        }
    }

    /* renamed from: a */
    public final String mo175868a(String str, int i) {
        if (str == null) {
            return null;
        }
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        String obj = str.subSequence(i2, length + 1).toString();
        if (i <= 0 || obj.length() <= i) {
            return obj;
        }
        String substring = obj.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }
}
