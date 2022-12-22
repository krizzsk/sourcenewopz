package com.didi.dqr.oned;

import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.EncodeHintType;
import com.didi.dqr.WriterException;
import com.didi.dqr.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {

    /* renamed from: a */
    private static final int f18699a = 103;

    /* renamed from: b */
    private static final int f18700b = 104;

    /* renamed from: c */
    private static final int f18701c = 105;

    /* renamed from: d */
    private static final int f18702d = 101;

    /* renamed from: e */
    private static final int f18703e = 100;

    /* renamed from: f */
    private static final int f18704f = 99;

    /* renamed from: g */
    private static final int f18705g = 106;

    /* renamed from: h */
    private static final char f18706h = 'ñ';

    /* renamed from: i */
    private static final char f18707i = 'ò';

    /* renamed from: j */
    private static final char f18708j = 'ó';

    /* renamed from: k */
    private static final char f18709k = 'ô';

    /* renamed from: l */
    private static final int f18710l = 102;

    /* renamed from: m */
    private static final int f18711m = 97;

    /* renamed from: n */
    private static final int f18712n = 96;

    /* renamed from: o */
    private static final int f18713o = 101;

    /* renamed from: p */
    private static final int f18714p = 100;

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt <= 127) {
                        break;
                    } else {
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int i7 = 103;
            if (i3 < length) {
                int a = m13885a(str, i3, i5);
                int i8 = 100;
                if (a == i5) {
                    switch (str.charAt(i3)) {
                        case 241:
                            i8 = 102;
                            break;
                        case 242:
                            i8 = 97;
                            break;
                        case 243:
                            i8 = 96;
                            break;
                        case 244:
                            if (i5 == 101) {
                                i8 = 101;
                                break;
                            }
                            break;
                        default:
                            if (i5 != 100) {
                                if (i5 == 101) {
                                    i8 = str.charAt(i3) - ' ';
                                    if (i8 < 0) {
                                        i8 += 96;
                                        break;
                                    }
                                } else {
                                    i8 = Integer.parseInt(str.substring(i3, i3 + 2));
                                    i3++;
                                    break;
                                }
                            } else {
                                i8 = str.charAt(i3) - ' ';
                                break;
                            }
                            break;
                    }
                    i3++;
                } else {
                    if (i5 != 0) {
                        i7 = a;
                    } else if (a == 100) {
                        i7 = 104;
                    } else if (a != 101) {
                        i7 = 105;
                    }
                    i8 = i7;
                    i5 = a;
                }
                arrayList.add(Code128Reader.f18683a[i8]);
                i4 += i8 * i6;
                if (i3 != 0) {
                    i6++;
                }
            } else {
                arrayList.add(Code128Reader.f18683a[i4 % 103]);
                arrayList.add(Code128Reader.f18683a[106]);
                int i9 = 0;
                for (int[] iArr : arrayList) {
                    for (int i10 : (int[]) r13.next()) {
                        i9 += i10;
                    }
                }
                boolean[] zArr = new boolean[i9];
                for (int[] appendPattern : arrayList) {
                    i += appendPattern(zArr, i, appendPattern, true);
                }
                return zArr;
            }
        }
    }

    /* renamed from: a */
    private static CType m13886a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    /* renamed from: a */
    private static int m13885a(CharSequence charSequence, int i, int i2) {
        CType a;
        CType a2;
        char charAt;
        CType a3 = m13886a(charSequence, i);
        if (a3 == CType.ONE_DIGIT) {
            return 100;
        }
        if (a3 == CType.UNCODABLE) {
            if (i >= charSequence.length() || ((charAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || charAt >= '`'))) {
                return 100;
            }
            return 101;
        } else if (i2 == 99) {
            return 99;
        } else {
            if (i2 != 100) {
                if (a3 == CType.FNC_1) {
                    a3 = m13886a(charSequence, i + 1);
                }
                if (a3 == CType.TWO_DIGITS) {
                    return 99;
                }
                return 100;
            } else if (a3 == CType.FNC_1 || (a = m13886a(charSequence, i + 2)) == CType.UNCODABLE || a == CType.ONE_DIGIT) {
                return 100;
            } else {
                if (a != CType.FNC_1) {
                    int i3 = i + 4;
                    while (true) {
                        a2 = m13886a(charSequence, i3);
                        if (a2 != CType.TWO_DIGITS) {
                            break;
                        }
                        i3 += 2;
                    }
                    if (a2 == CType.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                } else if (m13886a(charSequence, i + 3) == CType.TWO_DIGITS) {
                    return 99;
                } else {
                    return 100;
                }
            }
        }
    }
}
