package jumio.core;

import android.graphics.Path;

/* renamed from: jumio.core.l0 */
/* compiled from: SVGParser */
public class C21366l0 {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r4 != 'L') goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r2.mo175838a();
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        r23 = r12;
        r22 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
        r13 = r16;
        r12 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0189, code lost:
        r19 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x018b, code lost:
        if (r19 != false) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x018d, code lost:
        r16 = r5;
        r17 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0192, code lost:
        r17 = r12;
        r16 = r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Path m42143a(java.lang.String r24) {
        /*
            r0 = r24
            int r1 = r24.length()
            jumio.core.m0 r2 = new jumio.core.m0
            r3 = 0
            r2.<init>(r0, r3)
            r2.mo175844f()
            android.graphics.Path r14 = new android.graphics.Path
            r14.<init>()
            r15 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r12 = 0
            r13 = 0
            r16 = 0
            r17 = 0
        L_0x001e:
            int r7 = r2.f59650c
            if (r7 >= r1) goto L_0x01a1
            char r7 = r0.charAt(r7)
            r8 = 43
            r9 = 108(0x6c, float:1.51E-43)
            r10 = 99
            r11 = 109(0x6d, float:1.53E-43)
            if (r7 == r8) goto L_0x0038
            r8 = 45
            if (r7 == r8) goto L_0x0038
            switch(r7) {
                case 48: goto L_0x0038;
                case 49: goto L_0x0038;
                case 50: goto L_0x0038;
                case 51: goto L_0x0038;
                case 52: goto L_0x0038;
                case 53: goto L_0x0038;
                case 54: goto L_0x0038;
                case 55: goto L_0x0038;
                case 56: goto L_0x0038;
                case 57: goto L_0x0038;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x004d
        L_0x0038:
            if (r4 == r11) goto L_0x0054
            r8 = 77
            if (r4 != r8) goto L_0x003f
            goto L_0x0054
        L_0x003f:
            if (r4 == r10) goto L_0x0051
            r8 = 67
            if (r4 != r8) goto L_0x0046
            goto L_0x0051
        L_0x0046:
            if (r4 == r9) goto L_0x0051
            r8 = 76
            if (r4 != r8) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            r2.mo175838a()
            r4 = r7
        L_0x0051:
            r18 = r4
            goto L_0x005a
        L_0x0054:
            int r7 = r4 + -1
            char r7 = (char) r7
            r18 = r4
            r4 = r7
        L_0x005a:
            r19 = 1
            switch(r4) {
                case 65: goto L_0x014f;
                case 67: goto L_0x0111;
                case 72: goto L_0x00fd;
                case 76: goto L_0x00e5;
                case 77: goto L_0x00ca;
                case 83: goto L_0x0089;
                case 86: goto L_0x0077;
                case 90: goto L_0x0069;
                case 97: goto L_0x014f;
                case 99: goto L_0x0111;
                case 104: goto L_0x00fd;
                case 108: goto L_0x00e5;
                case 109: goto L_0x00ca;
                case 115: goto L_0x0089;
                case 118: goto L_0x0077;
                case 122: goto L_0x0069;
                default: goto L_0x005f;
            }
        L_0x005f:
            r23 = r12
            r22 = r13
        L_0x0063:
            r13 = r16
            r12 = r17
            goto L_0x0189
        L_0x0069:
            r14.close()
            r14.moveTo(r13, r12)
            r6 = r12
            r23 = r6
            r5 = r13
            r22 = r5
            goto L_0x018b
        L_0x0077:
            float r7 = r2.mo175840b()
            r8 = 118(0x76, float:1.65E-43)
            if (r4 != r8) goto L_0x0084
            r14.rLineTo(r15, r7)
            float r6 = r6 + r7
            goto L_0x005f
        L_0x0084:
            r14.lineTo(r5, r7)
            r6 = r7
            goto L_0x005f
        L_0x0089:
            float r7 = r2.mo175840b()
            float r8 = r2.mo175840b()
            float r9 = r2.mo175840b()
            float r10 = r2.mo175840b()
            r11 = 115(0x73, float:1.61E-43)
            if (r4 != r11) goto L_0x00a1
            float r7 = r7 + r5
            float r9 = r9 + r5
            float r8 = r8 + r6
            float r10 = r10 + r6
        L_0x00a1:
            r11 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r4 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 * r4
            float r5 = r5 - r16
            float r6 = r6 * r4
            float r6 = r6 - r17
            r4 = r14
            r7 = r11
            r8 = r20
            r9 = r21
            r10 = r22
            r4.cubicTo(r5, r6, r7, r8, r9, r10)
            r23 = r12
            r12 = r20
            r5 = r21
            r6 = r22
            r22 = r13
        L_0x00c7:
            r13 = r11
            goto L_0x018b
        L_0x00ca:
            float r7 = r2.mo175840b()
            float r8 = r2.mo175840b()
            if (r4 != r11) goto L_0x00da
            float r13 = r13 + r7
            float r12 = r12 + r8
            r14.rMoveTo(r7, r8)
            goto L_0x00f2
        L_0x00da:
            r14.moveTo(r7, r8)
            r5 = r7
            r22 = r5
            r6 = r8
            r23 = r6
            goto L_0x0063
        L_0x00e5:
            float r7 = r2.mo175840b()
            float r8 = r2.mo175840b()
            if (r4 != r9) goto L_0x00f6
            r14.rLineTo(r7, r8)
        L_0x00f2:
            float r5 = r5 + r7
            float r6 = r6 + r8
            goto L_0x005f
        L_0x00f6:
            r14.lineTo(r7, r8)
            r5 = r7
            r6 = r8
            goto L_0x005f
        L_0x00fd:
            float r7 = r2.mo175840b()
            r8 = 104(0x68, float:1.46E-43)
            if (r4 != r8) goto L_0x010b
            r14.rLineTo(r7, r15)
            float r5 = r5 + r7
            goto L_0x005f
        L_0x010b:
            r14.lineTo(r7, r6)
            r5 = r7
            goto L_0x005f
        L_0x0111:
            float r7 = r2.mo175840b()
            float r8 = r2.mo175840b()
            float r9 = r2.mo175840b()
            float r11 = r2.mo175840b()
            float r16 = r2.mo175840b()
            float r17 = r2.mo175840b()
            if (r4 != r10) goto L_0x0133
            float r7 = r7 + r5
            float r9 = r9 + r5
            float r16 = r16 + r5
            float r8 = r8 + r6
            float r11 = r11 + r6
            float r17 = r17 + r6
        L_0x0133:
            r5 = r7
            r6 = r8
            r20 = r11
            r11 = r9
            r4 = r14
            r7 = r11
            r8 = r20
            r9 = r16
            r10 = r17
            r4.cubicTo(r5, r6, r7, r8, r9, r10)
            r23 = r12
            r22 = r13
            r5 = r16
            r6 = r17
            r12 = r20
            goto L_0x00c7
        L_0x014f:
            float r9 = r2.mo175840b()
            float r10 = r2.mo175840b()
            float r11 = r2.mo175840b()
            float r4 = r2.mo175840b()
            int r8 = (int) r4
            float r4 = r2.mo175840b()
            int r7 = (int) r4
            float r19 = r2.mo175840b()
            float r20 = r2.mo175840b()
            r4 = r14
            r21 = r7
            r7 = r19
            r22 = r8
            r8 = r20
            r23 = r12
            r12 = r22
            r22 = r13
            r13 = r21
            m42144a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r13 = r16
            r12 = r17
            r5 = r19
            r6 = r20
        L_0x0189:
            r19 = 0
        L_0x018b:
            if (r19 != 0) goto L_0x0192
            r16 = r5
            r17 = r6
            goto L_0x0196
        L_0x0192:
            r17 = r12
            r16 = r13
        L_0x0196:
            r2.mo175844f()
            r4 = r18
            r13 = r22
            r12 = r23
            goto L_0x001e
        L_0x01a1:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21366l0.m42143a(java.lang.String):android.graphics.Path");
    }

    /* renamed from: a */
    public static void m42144a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, int i2) {
    }
}
