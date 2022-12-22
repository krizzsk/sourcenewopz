package p242io.socket.utf8;

import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

/* renamed from: io.socket.utf8.UTF8 */
public final class UTF8 {

    /* renamed from: a */
    private static final String f59560a = "Invalid continuation byte";

    /* renamed from: b */
    private static int[] f59561b;

    /* renamed from: c */
    private static int f59562c;

    /* renamed from: d */
    private static int f59563d;

    /* renamed from: io.socket.utf8.UTF8$Options */
    public static class Options {
        public boolean strict = true;
    }

    private UTF8() {
    }

    public static String encode(String str) throws UTF8Exception {
        return encode(str, new Options());
    }

    public static String encode(String str, Options options) throws UTF8Exception {
        boolean z = options.strict;
        int[] a = m42081a(str);
        int length = a.length;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        while (true) {
            i++;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(m42078a(a[i], z));
        }
    }

    public static String decode(String str) throws UTF8Exception {
        return decode(str, new Options());
    }

    public static String decode(String str, Options options) throws UTF8Exception {
        boolean z = options.strict;
        int[] a = m42081a(str);
        f59561b = a;
        f59562c = a.length;
        f59563d = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int a2 = m42077a(z);
            if (a2 == -1) {
                return m42079a(m42082a((List<Integer>) arrayList));
            }
            arrayList.add(Integer.valueOf(a2));
        }
    }

    /* renamed from: a */
    private static int[] m42081a(String str) {
        int length = str.length();
        int i = 0;
        int[] iArr = new int[str.codePointCount(0, length)];
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return iArr;
    }

    /* renamed from: a */
    private static String m42078a(int i, boolean z) throws UTF8Exception {
        StringBuilder sb = new StringBuilder();
        if ((i & -128) == 0) {
            sb.append(Character.toChars(i));
            return sb.toString();
        }
        if ((i & -2048) == 0) {
            sb.append(Character.toChars(((i >> 6) & 31) | 192));
        } else if ((-65536 & i) == 0) {
            if (!m42083b(i, z)) {
                i = Utf8.REPLACEMENT_CODE_POINT;
            }
            sb.append(Character.toChars(((i >> 12) & 15) | 224));
            sb.append(m42080a(i, 6));
        } else if ((-2097152 & i) == 0) {
            sb.append(Character.toChars(((i >> 18) & 7) | 240));
            sb.append(m42080a(i, 12));
            sb.append(m42080a(i, 6));
        }
        sb.append(Character.toChars((i & 63) | 128));
        return sb.toString();
    }

    /* renamed from: a */
    private static char[] m42080a(int i, int i2) {
        return Character.toChars(((i >> i2) & 63) | 128);
    }

    /* renamed from: a */
    private static int m42077a(boolean z) throws UTF8Exception {
        int i = f59563d;
        int i2 = f59562c;
        if (i > i2) {
            throw new UTF8Exception("Invalid byte index");
        } else if (i == i2) {
            return -1;
        } else {
            int i3 = f59561b[i] & 255;
            f59563d = i + 1;
            if ((i3 & 128) == 0) {
                return i3;
            }
            if ((i3 & 224) == 192) {
                int a = m42076a() | ((i3 & 31) << 6);
                if (a >= 128) {
                    return a;
                }
                throw new UTF8Exception(f59560a);
            } else if ((i3 & 240) == 224) {
                int a2 = (m42076a() << 6) | ((i3 & 15) << 12) | m42076a();
                if (a2 >= 2048) {
                    return m42083b(a2, z) ? a2 : Utf8.REPLACEMENT_CODE_POINT;
                }
                throw new UTF8Exception(f59560a);
            } else {
                if ((i3 & 248) == 240) {
                    int a3 = (m42076a() << 12) | ((i3 & 15) << 18) | (m42076a() << 6) | m42076a();
                    if (a3 >= 65536 && a3 <= 1114111) {
                        return a3;
                    }
                }
                throw new UTF8Exception(f59560a);
            }
        }
    }

    /* renamed from: a */
    private static int m42076a() throws UTF8Exception {
        int i = f59563d;
        if (i < f59562c) {
            int i2 = f59561b[i] & 255;
            f59563d = i + 1;
            if ((i2 & 192) == 128) {
                return i2 & 63;
            }
            throw new UTF8Exception(f59560a);
        }
        throw new UTF8Exception("Invalid byte index");
    }

    /* renamed from: a */
    private static String m42079a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int appendCodePoint : iArr) {
            sb.appendCodePoint(appendCodePoint);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m42083b(int i, boolean z) throws UTF8Exception {
        if (i < 55296 || i > 57343) {
            return true;
        }
        if (!z) {
            return false;
        }
        throw new UTF8Exception("Lone surrogate U+" + Integer.toHexString(i).toUpperCase() + " is not a scalar value");
    }

    /* renamed from: a */
    private static int[] m42082a(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
