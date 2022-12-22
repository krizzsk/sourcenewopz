package com.didi.dqr.datamatrix.encoder;

import com.didi.dqr.Dimension;
import java.util.Arrays;
import org.osgi.framework.VersionRange;

public final class HighLevelEncoder {

    /* renamed from: a */
    static final char f18620a = 'æ';

    /* renamed from: b */
    static final char f18621b = 'ç';

    /* renamed from: c */
    static final char f18622c = 'ë';

    /* renamed from: d */
    static final char f18623d = 'î';

    /* renamed from: e */
    static final char f18624e = 'ï';

    /* renamed from: f */
    static final char f18625f = 'ð';

    /* renamed from: g */
    static final char f18626g = 'þ';

    /* renamed from: h */
    static final char f18627h = 'þ';

    /* renamed from: i */
    static final int f18628i = 0;

    /* renamed from: j */
    static final int f18629j = 1;

    /* renamed from: k */
    static final int f18630k = 2;

    /* renamed from: l */
    static final int f18631l = 3;

    /* renamed from: m */
    static final int f18632m = 4;

    /* renamed from: n */
    static final int f18633n = 5;

    /* renamed from: o */
    private static final char f18634o = '';

    /* renamed from: p */
    private static final char f18635p = 'ì';

    /* renamed from: q */
    private static final char f18636q = 'í';

    /* renamed from: r */
    private static final String f18637r = "[)>\u001e05\u001d";

    /* renamed from: s */
    private static final String f18638s = "[)>\u001e06\u001d";

    /* renamed from: t */
    private static final String f18639t = "\u001e\u0004";

    /* renamed from: a */
    static boolean m13813a(char c) {
        return c >= '0' && c <= '9';
    }

    /* renamed from: b */
    static boolean m13814b(char c) {
        return c >= 128 && c <= 255;
    }

    /* renamed from: d */
    private static boolean m13816d(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    /* renamed from: e */
    private static boolean m13817e(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    /* renamed from: g */
    private static boolean m13819g(char c) {
        return c == 13 || c == '*' || c == '>';
    }

    /* renamed from: h */
    private static boolean m13820h(char c) {
        return c >= ' ' && c <= '^';
    }

    /* renamed from: i */
    private static boolean m13821i(char c) {
        return false;
    }

    private HighLevelEncoder() {
    }

    /* renamed from: a */
    private static char m13809a(int i) {
        int i2 = ((i * 149) % 253) + 1 + 129;
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    public static String encodeHighLevel(String str) {
        return encodeHighLevel(str, SymbolShapeHint.FORCE_NONE, (Dimension) null, (Dimension) null);
    }

    public static String encodeHighLevel(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        int i = 0;
        C7844f[] fVarArr = {new C7839a(), new C7841c(), new C7846h(), new C7847i(), new C7843e(), new C7840b()};
        C7845g gVar = new C7845g(str);
        gVar.mo58346a(symbolShapeHint);
        gVar.mo58345a(dimension, dimension2);
        if (str.startsWith(f18637r) && str.endsWith(f18639t)) {
            gVar.mo58343a((char) f18635p);
            gVar.mo58344a(2);
            gVar.f18648a += 7;
        } else if (str.startsWith(f18638s) && str.endsWith(f18639t)) {
            gVar.mo58343a((char) f18636q);
            gVar.mo58344a(2);
            gVar.f18648a += 7;
        }
        while (gVar.mo58356h()) {
            fVarArr[i].mo58339a(gVar);
            if (gVar.mo58354f() >= 0) {
                i = gVar.mo58354f();
                gVar.mo58355g();
            }
        }
        int e = gVar.mo58353e();
        gVar.mo58359k();
        int dataCapacity = gVar.mo58358j().getDataCapacity();
        if (!(e >= dataCapacity || i == 0 || i == 5 || i == 4)) {
            gVar.mo58343a(254);
        }
        StringBuilder d = gVar.mo58352d();
        if (d.length() < dataCapacity) {
            d.append(f18634o);
        }
        while (d.length() < dataCapacity) {
            d.append(m13809a(d.length() + 1));
        }
        return gVar.mo58352d().toString();
    }

    /* renamed from: a */
    static int m13810a(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        char c;
        CharSequence charSequence2 = charSequence;
        int i3 = i;
        if (i3 >= charSequence.length()) {
            return i2;
        }
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int a = m13812a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int a2 = m13811a(bArr);
                if (iArr[0] == a) {
                    return 0;
                }
                if (a2 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (a2 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (a2 != 1 || bArr[2] <= 0) {
                    return (a2 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence2.charAt(i5);
            i4++;
            if (m13813a(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (m13814b(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (m13816d(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (m13814b(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (m13817e(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (m13814b(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (m13818f(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (m13814b(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (m13820h(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (m13814b(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (m13821i(charAt)) {
                c = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                m13812a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int a3 = m13811a(bArr2);
                if (iArr2[0] < iArr2[c] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (a3 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (a3 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (a3 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i6 = i3 + i4 + 1; i6 < charSequence.length(); i6++) {
                            char charAt2 = charSequence2.charAt(i6);
                            if (m13819g(charAt2)) {
                                return 3;
                            }
                            if (!m13818f(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static int m13812a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i2 = 0; i2 < 6; i2++) {
            iArr[i2] = (int) Math.ceil((double) fArr[i2]);
            int i3 = iArr[i2];
            if (i > i3) {
                Arrays.fill(bArr, (byte) 0);
                i = i3;
            }
            if (i == i3) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    /* renamed from: a */
    private static int m13811a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    /* renamed from: f */
    private static boolean m13818f(char c) {
        return m13819g(c) || c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (m13813a(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    /* renamed from: c */
    static void m13815c(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + VersionRange.RIGHT_OPEN);
    }
}
