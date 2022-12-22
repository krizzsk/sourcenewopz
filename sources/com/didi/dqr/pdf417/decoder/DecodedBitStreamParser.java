package com.didi.dqr.pdf417.decoder;

import com.didi.dqr.FormatException;
import com.didi.dqr.common.CharacterSetECI;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

final class DecodedBitStreamParser {

    /* renamed from: A */
    private static final char[] f18880A = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: B */
    private static final char[] f18881B = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: C */
    private static final BigInteger[] f18882C;

    /* renamed from: D */
    private static final int f18883D = 2;

    /* renamed from: a */
    private static final int f18884a = 900;

    /* renamed from: b */
    private static final int f18885b = 901;

    /* renamed from: c */
    private static final int f18886c = 902;

    /* renamed from: d */
    private static final int f18887d = 924;

    /* renamed from: e */
    private static final int f18888e = 925;

    /* renamed from: f */
    private static final int f18889f = 926;

    /* renamed from: g */
    private static final int f18890g = 927;

    /* renamed from: h */
    private static final int f18891h = 928;

    /* renamed from: i */
    private static final int f18892i = 923;

    /* renamed from: j */
    private static final int f18893j = 922;

    /* renamed from: k */
    private static final int f18894k = 913;

    /* renamed from: l */
    private static final int f18895l = 15;

    /* renamed from: m */
    private static final int f18896m = 0;

    /* renamed from: n */
    private static final int f18897n = 1;

    /* renamed from: o */
    private static final int f18898o = 2;

    /* renamed from: p */
    private static final int f18899p = 3;

    /* renamed from: q */
    private static final int f18900q = 4;

    /* renamed from: r */
    private static final int f18901r = 5;

    /* renamed from: s */
    private static final int f18902s = 6;

    /* renamed from: t */
    private static final int f18903t = 25;

    /* renamed from: u */
    private static final int f18904u = 27;

    /* renamed from: v */
    private static final int f18905v = 27;

    /* renamed from: w */
    private static final int f18906w = 28;

    /* renamed from: x */
    private static final int f18907x = 28;

    /* renamed from: y */
    private static final int f18908y = 29;

    /* renamed from: z */
    private static final int f18909z = 29;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f18882C = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        f18882C[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f18882C;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    /* renamed from: a */
    static DecoderResult m14048a(int[] iArr, String str) throws FormatException {
        int i;
        int i2 = 2;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i3 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        while (i2 < iArr[0]) {
            if (i3 != 913) {
                switch (i3) {
                    case 900:
                        i = m14047a(iArr, i2, sb);
                        break;
                    case 901:
                        i = m14045a(i3, iArr, charset, i2, sb);
                        break;
                    case 902:
                        i = m14051b(iArr, i2, sb);
                        break;
                    default:
                        switch (i3) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i = i2 + 1;
                                break;
                            case 926:
                                i = i2 + 2;
                                break;
                            case 927:
                                Charset forName = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i2]).name());
                                i = i2 + 1;
                                charset = forName;
                                break;
                            case 928:
                                i = m14046a(iArr, i2, pDF417ResultMetadata);
                                break;
                            default:
                                i = m14047a(iArr, i2 - 1, sb);
                                break;
                        }
                        i = m14045a(i3, iArr, charset, i2, sb);
                        break;
                }
            } else {
                sb.append((char) iArr[i2]);
                i = i2 + 1;
            }
            if (i < iArr.length) {
                int i4 = i + 1;
                i3 = iArr[i];
                i2 = i4;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    /* renamed from: a */
    static int m14046a(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = 0;
            while (i2 < 2) {
                iArr2[i2] = iArr[i];
                i2++;
                i++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(m14049a(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int a = m14047a(iArr, i, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            int i3 = iArr[a] == 923 ? a + 1 : -1;
            while (a < iArr[0]) {
                int i4 = iArr[a];
                if (i4 == 922) {
                    a++;
                    pDF417ResultMetadata.setLastSegment(true);
                } else if (i4 == 923) {
                    int i5 = a + 1;
                    switch (iArr[i5]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            a = m14047a(iArr, i5 + 1, sb2);
                            pDF417ResultMetadata.setFileName(sb2.toString());
                            break;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            a = m14051b(iArr, i5 + 1, sb3);
                            pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb3.toString()));
                            break;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            a = m14051b(iArr, i5 + 1, sb4);
                            pDF417ResultMetadata.setTimestamp(Long.parseLong(sb4.toString()));
                            break;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            a = m14047a(iArr, i5 + 1, sb5);
                            pDF417ResultMetadata.setSender(sb5.toString());
                            break;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            a = m14047a(iArr, i5 + 1, sb6);
                            pDF417ResultMetadata.setAddressee(sb6.toString());
                            break;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            a = m14051b(iArr, i5 + 1, sb7);
                            pDF417ResultMetadata.setFileSize(Long.parseLong(sb7.toString()));
                            break;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            a = m14051b(iArr, i5 + 1, sb8);
                            pDF417ResultMetadata.setChecksum(Integer.parseInt(sb8.toString()));
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i3 != -1) {
                int i6 = a - i3;
                if (pDF417ResultMetadata.isLastSegment()) {
                    i6--;
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i3, i6 + i3));
            }
            return a;
        }
        throw FormatException.getFormatInstance();
    }

    /* renamed from: a */
    private static int m14047a(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i) * 2)];
        int[] iArr3 = new int[((iArr[0] - i) * 2)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != 913) {
                if (i4 != 928) {
                    switch (i4) {
                        case 900:
                            iArr2[i2] = 900;
                            i2++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i4) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                            }
                    }
                }
                i3--;
                z = true;
            } else {
                iArr2[i2] = 913;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
            continue;
        }
        m14050a(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        r4 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b7, code lost:
        r4 = (char) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b8, code lost:
        r11 = r1;
        r1 = r0;
        r0 = r4;
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c7, code lost:
        r6 = 0;
        r11 = r1;
        r1 = r0;
        r0 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d8, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00dd, code lost:
        r4 = r1;
        r1 = r0;
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e0, code lost:
        if (r0 == 0) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e2, code lost:
        r15.append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e5, code lost:
        r3 = r3 + 1;
        r0 = r1;
        r1 = r4;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m14050a(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r2 = 0
            r3 = 0
        L_0x0006:
            if (r3 >= r14) goto L_0x00eb
            r4 = r12[r3]
            int[] r5 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.C78751.f18910x57a9616b
            int r6 = r0.ordinal()
            r5 = r5[r6]
            r6 = 32
            r7 = 29
            r8 = 26
            r9 = 913(0x391, float:1.28E-42)
            r10 = 900(0x384, float:1.261E-42)
            switch(r5) {
                case 1: goto L_0x00b3;
                case 2: goto L_0x0093;
                case 3: goto L_0x006c;
                case 4: goto L_0x0053;
                case 5: goto L_0x003d;
                case 6: goto L_0x0024;
                default: goto L_0x001f;
            }
        L_0x001f:
            r4 = r1
            r1 = r0
        L_0x0021:
            r0 = 0
            goto L_0x00e0
        L_0x0024:
            if (r4 >= r7) goto L_0x002b
            char[] r0 = f18880A
            char r0 = r0[r4]
            goto L_0x0042
        L_0x002b:
            if (r4 == r7) goto L_0x003a
            if (r4 == r10) goto L_0x003a
            if (r4 == r9) goto L_0x0032
            goto L_0x0038
        L_0x0032:
            r0 = r13[r3]
            char r0 = (char) r0
            r15.append(r0)
        L_0x0038:
            r4 = r1
            goto L_0x0021
        L_0x003a:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x001f
        L_0x003d:
            if (r4 >= r8) goto L_0x0045
            int r4 = r4 + 65
            char r0 = (char) r4
        L_0x0042:
            r4 = r1
            goto L_0x00e0
        L_0x0045:
            if (r4 == r8) goto L_0x0050
            if (r4 == r10) goto L_0x004c
            r0 = r1
            goto L_0x00d8
        L_0x004c:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00d8
        L_0x0050:
            r0 = r1
            goto L_0x00dd
        L_0x0053:
            if (r4 >= r7) goto L_0x005b
            char[] r5 = f18880A
            char r4 = r5[r4]
            goto L_0x00b8
        L_0x005b:
            if (r4 == r7) goto L_0x0069
            if (r4 == r10) goto L_0x0069
            if (r4 == r9) goto L_0x0062
            goto L_0x001f
        L_0x0062:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x001f
        L_0x0069:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x001f
        L_0x006c:
            r5 = 25
            if (r4 >= r5) goto L_0x0075
            char[] r5 = f18881B
            char r4 = r5[r4]
            goto L_0x00b8
        L_0x0075:
            if (r4 == r10) goto L_0x0090
            if (r4 == r9) goto L_0x0089
            switch(r4) {
                case 25: goto L_0x0085;
                case 26: goto L_0x00dd;
                case 27: goto L_0x0081;
                case 28: goto L_0x0090;
                case 29: goto L_0x007e;
                default: goto L_0x007c;
            }
        L_0x007c:
            goto L_0x00d8
        L_0x007e:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00c7
        L_0x0081:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00d8
        L_0x0085:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x00d8
        L_0x0089:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00d8
        L_0x0090:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00d8
        L_0x0093:
            if (r4 >= r8) goto L_0x0098
            int r4 = r4 + 97
            goto L_0x00b7
        L_0x0098:
            if (r4 == r10) goto L_0x00b0
            if (r4 == r9) goto L_0x00a9
            switch(r4) {
                case 26: goto L_0x00dd;
                case 27: goto L_0x00a6;
                case 28: goto L_0x00a3;
                case 29: goto L_0x00a0;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x00d8
        L_0x00a0:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00c7
        L_0x00a3:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00d8
        L_0x00a6:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
            goto L_0x00c7
        L_0x00a9:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
            goto L_0x00d8
        L_0x00b0:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00d8
        L_0x00b3:
            if (r4 >= r8) goto L_0x00bd
            int r4 = r4 + 65
        L_0x00b7:
            char r4 = (char) r4
        L_0x00b8:
            r11 = r1
            r1 = r0
            r0 = r4
            r4 = r11
            goto L_0x00e0
        L_0x00bd:
            if (r4 == r10) goto L_0x00da
            if (r4 == r9) goto L_0x00d2
            switch(r4) {
                case 26: goto L_0x00dd;
                case 27: goto L_0x00cf;
                case 28: goto L_0x00cc;
                case 29: goto L_0x00c5;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            goto L_0x00d8
        L_0x00c5:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
        L_0x00c7:
            r6 = 0
            r11 = r1
            r1 = r0
            r0 = r11
            goto L_0x00dd
        L_0x00cc:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00d8
        L_0x00cf:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00d8
        L_0x00d2:
            r4 = r13[r3]
            char r4 = (char) r4
            r15.append(r4)
        L_0x00d8:
            r6 = 0
            goto L_0x00dd
        L_0x00da:
            com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00d8
        L_0x00dd:
            r4 = r1
            r1 = r0
            r0 = r6
        L_0x00e0:
            if (r0 == 0) goto L_0x00e5
            r15.append(r0)
        L_0x00e5:
            int r3 = r3 + 1
            r0 = r1
            r1 = r4
            goto L_0x0006
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.m14050a(int[], int[], int, java.lang.StringBuilder):void");
    }

    /* renamed from: com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$1 */
    static /* synthetic */ class C78751 {

        /* renamed from: $SwitchMap$com$didi$dqr$pdf417$decoder$DecodedBitStreamParser$Mode */
        static final /* synthetic */ int[] f18910x57a9616b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode[] r0 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18910x57a9616b = r0
                com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18910x57a9616b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18910x57a9616b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f18910x57a9616b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f18910x57a9616b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f18910x57a9616b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.dqr.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.pdf417.decoder.DecodedBitStreamParser.C78751.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static int m14045a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        long j;
        int i5;
        int i6;
        int i7 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j2 = 900;
        int i8 = 6;
        if (i7 == 901) {
            int[] iArr2 = new int[6];
            int i9 = i2 + 1;
            int i10 = iArr[i2];
            boolean z = false;
            while (true) {
                i6 = 0;
                long j3 = 0;
                while (i5 < iArr[0] && !z) {
                    int i11 = i6 + 1;
                    iArr2[i6] = i4;
                    j3 = (j3 * j) + ((long) i4);
                    int i12 = i5 + 1;
                    i10 = iArr[i5];
                    if (i10 != 928) {
                        switch (i10) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i10) {
                                    case 922:
                                    case 923:
                                    case 924:
                                        break;
                                    default:
                                        if (i11 % 5 != 0 || i11 <= 0) {
                                            i4 = i10;
                                            i5 = i12;
                                            i6 = i11;
                                            j = 900;
                                            i8 = 6;
                                            break;
                                        } else {
                                            int i13 = 0;
                                            while (i13 < i8) {
                                                byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i13) * 8))));
                                                i13++;
                                                i10 = i10;
                                                i8 = 6;
                                            }
                                            int i14 = i10;
                                            i9 = i12;
                                            j2 = 900;
                                        }
                                }
                                break;
                        }
                    }
                    i5 = i12 - 1;
                    i4 = i10;
                    i6 = i11;
                    j = 900;
                    i8 = 6;
                    z = true;
                }
            }
            if (i5 == iArr[0] && i4 < 900) {
                iArr2[i6] = i4;
                i6++;
            }
            for (int i15 = 0; i15 < i6; i15++) {
                byteArrayOutputStream.write((byte) iArr2[i15]);
            }
            i3 = i5;
        } else if (i7 != 924) {
            i3 = i2;
        } else {
            i3 = i2;
            boolean z2 = false;
            while (true) {
                int i16 = 0;
                long j4 = 0;
                while (i3 < iArr[0] && !z2) {
                    int i17 = i3 + 1;
                    int i18 = iArr[i3];
                    if (i18 < 900) {
                        i16++;
                        j4 = (j4 * 900) + ((long) i18);
                    } else {
                        if (i18 != 928) {
                            switch (i18) {
                                case 900:
                                case 901:
                                case 902:
                                    break;
                                default:
                                    switch (i18) {
                                        case 922:
                                        case 923:
                                        case 924:
                                            break;
                                    }
                            }
                        }
                        i3 = i17 - 1;
                        z2 = true;
                        if (i16 % 5 != 0 && i16 > 0) {
                            for (int i19 = 0; i19 < 6; i19++) {
                                byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i19) * 8))));
                            }
                        }
                    }
                    i3 = i17;
                    if (i16 % 5 != 0) {
                    }
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* renamed from: b */
    private static int m14051b(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
            } else {
                if (!(i4 == 900 || i4 == 901 || i4 == 928)) {
                    switch (i4) {
                        case 922:
                        case 923:
                        case 924:
                            break;
                    }
                }
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                sb.append(m14049a(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    /* renamed from: a */
    private static String m14049a(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(f18882C[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
