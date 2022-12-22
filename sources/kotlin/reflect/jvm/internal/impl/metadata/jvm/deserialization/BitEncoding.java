package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

public class BitEncoding {

    /* renamed from: a */
    static final /* synthetic */ boolean f60702a = (!BitEncoding.class.desiredAssertionStatus());

    /* renamed from: b */
    private static final boolean f60703b;

    /* renamed from: a */
    private static /* synthetic */ void m44758a(int i) {
        int i2 = i;
        String str = (i2 == 1 || i2 == 3 || i2 == 6 || i2 == 8 || i2 == 10 || i2 == 12 || i2 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i2 == 1 || i2 == 3 || i2 == 6 || i2 == 8 || i2 == 10 || i2 == 12 || i2 == 14) ? 2 : 3)];
        if (i2 == 1 || i2 == 3 || i2 == 6 || i2 == 8 || i2 == 10 || i2 == 12 || i2 == 14) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[0] = "data";
        }
        if (i2 == 1) {
            objArr[1] = "encodeBytes";
        } else if (i2 == 3) {
            objArr[1] = "encode8to7";
        } else if (i2 == 6) {
            objArr[1] = "splitBytesToStringArray";
        } else if (i2 == 8) {
            objArr[1] = "decodeBytes";
        } else if (i2 == 10) {
            objArr[1] = "dropMarker";
        } else if (i2 == 12) {
            objArr[1] = "combineStringArrayIntoBytes";
        } else if (i2 != 14) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[1] = "decode7to8";
        }
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i2 == 1 || i2 == 3 || i2 == 6 || i2 == 8 || i2 == 10 || i2 == 12 || i2 == 14) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        f60703b = "true".equals(str);
    }

    private BitEncoding() {
    }

    /* renamed from: a */
    private static void m44759a(byte[] bArr, int i) {
        if (bArr == null) {
            m44758a(4);
        }
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) ((bArr[i2] + i) & 127);
        }
    }

    public static byte[] decodeBytes(String[] strArr) {
        if (strArr == null) {
            m44758a(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                byte[] stringsToBytes = UtfEncodingKt.stringsToBytes(m44761a(strArr));
                if (stringsToBytes == null) {
                    m44758a(8);
                }
                return stringsToBytes;
            } else if (charAt == 65535) {
                strArr = m44761a(strArr);
            }
        }
        byte[] b = m44762b(strArr);
        m44759a(b, 127);
        return m44760a(b);
    }

    /* renamed from: a */
    private static String[] m44761a(String[] strArr) {
        if (strArr == null) {
            m44758a(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        if (strArr2 == null) {
            m44758a(10);
        }
        return strArr2;
    }

    /* renamed from: b */
    private static byte[] m44762b(String[] strArr) {
        if (strArr == null) {
            m44758a(11);
        }
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            if (f60702a || str.length() <= 65535) {
                i2 += str.length();
                i++;
            } else {
                throw new AssertionError("String is too long: " + str.length());
            }
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (String str2 : strArr) {
            int length2 = str2.length();
            int i4 = 0;
            while (i4 < length2) {
                bArr[i3] = (byte) str2.charAt(i4);
                i4++;
                i3++;
            }
        }
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m44760a(byte[] bArr) {
        if (bArr == null) {
            m44758a(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i = 0;
        byte b = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i++;
            int i3 = b + 1;
            bArr2[i2] = (byte) (((bArr[i] & 255) >>> b) + ((bArr[i] & ((1 << i3) - 1)) << (7 - b)));
            if (b == 6) {
                i++;
                b = 0;
            } else {
                b = i3;
            }
        }
        return bArr2;
    }
}
