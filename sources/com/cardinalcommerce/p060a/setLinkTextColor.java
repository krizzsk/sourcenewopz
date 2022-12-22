package com.cardinalcommerce.p060a;

import java.io.Serializable;
import org.apache.commons.p071io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setLinkTextColor */
public final class setLinkTextColor implements Serializable {
    private static int Cardinal = 0;
    private static int cleanup = 1;
    private String cca_continue;
    private String configure;
    private String getInstance;
    public boolean init;

    public setLinkTextColor() {
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.String] */
    public static String getInstance(Class<?> cls) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        boolean z = true;
        int i = (cleanup + 7) - 1;
        int i2 = (i ^ -1) + ((i & -1) << 1);
        Cardinal = i2 % 128;
        int i3 = i2 % 2;
        int i4 = 1;
        while (true) {
            ? r5 = 0;
            if (!(i4 >= stackTrace.length)) {
                int i5 = cleanup;
                int i6 = i5 & 113;
                int i7 = -(-((i5 ^ 113) | i6));
                int i8 = (i6 ^ i7) + ((i7 & i6) << 1);
                Cardinal = i8 % 128;
                if (i8 % 2 == 0) {
                    stackTraceElement = stackTrace[i4];
                    if ((!stackTraceElement.getClassName().equals(cls.getName()) ? 3 : 'G') != 3) {
                        continue;
                        int i9 = (i4 + 98) - 1;
                        i4 = ((i9 | -96) << 1) - (i9 ^ -96);
                        int i10 = cleanup;
                        int i11 = i10 ^ 21;
                        int i12 = -(-((i10 & 21) << 1));
                        int i13 = (i11 ^ i12) + ((i12 & i11) << 1);
                        Cardinal = i13 % 128;
                        int i14 = i13 % 2;
                    }
                } else {
                    stackTraceElement = stackTrace[i4];
                    int i15 = 1 / 0;
                    if (!(!stackTraceElement.getClassName().equals(cls.getName()))) {
                        continue;
                        int i92 = (i4 + 98) - 1;
                        i4 = ((i92 | -96) << 1) - (i92 ^ -96);
                        int i102 = cleanup;
                        int i112 = i102 ^ 21;
                        int i122 = -(-((i102 & 21) << 1));
                        int i132 = (i112 ^ i122) + ((i122 & i112) << 1);
                        Cardinal = i132 % 128;
                        int i142 = i132 % 2;
                    }
                }
                if ((stackTraceElement.getClassName().indexOf("java.lang.Thread") != 0 ? '1' : Matrix.MATRIX_TYPE_RANDOM_REGULAR) != 'R') {
                    int i16 = Cardinal;
                    int i17 = (((i16 ^ 86) + ((i16 & 86) << 1)) - 0) - 1;
                    cleanup = i17 % 128;
                    if ((i17 % 2 == 0 ? 'V' : 22) != 'V') {
                        return stackTraceElement.getClassName();
                    }
                    String className = stackTraceElement.getClassName();
                    int length = r5.length;
                    return className;
                }
                int i922 = (i4 + 98) - 1;
                i4 = ((i922 | -96) << 1) - (i922 ^ -96);
                int i1022 = cleanup;
                int i1122 = i1022 ^ 21;
                int i1222 = -(-((i1022 & 21) << 1));
                int i1322 = (i1122 ^ i1222) + ((i1222 & i1122) << 1);
                Cardinal = i1322 % 128;
                int i1422 = i1322 % 2;
            } else {
                int i18 = (Cardinal + 21) - 1;
                int i19 = ((i18 | -1) << 1) - (i18 ^ -1);
                cleanup = i19 % 128;
                if (i19 % 2 == 0) {
                    z = false;
                }
                if (z) {
                    return r5;
                }
                int length2 = r5.length;
                return r5;
            }
        }
    }

    public setLinkTextColor(String str) {
        if (str.contains("{}") || str.equals("")) {
            this.init = true;
        } else {
            this.init = cca_continue(str);
        }
    }

    private boolean cca_continue(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Object[] objArr = null;
            boolean z = true;
            if ((jSONObject.has("medium") ? '^' : 11) == '^') {
                int i = Cardinal;
                int i2 = (i ^ 125) + ((i & 125) << 1);
                cleanup = i2 % 128;
                if (!(i2 % 2 == 0)) {
                    this.getInstance = jSONObject.optString("medium", "");
                } else {
                    this.getInstance = jSONObject.optString("medium", "");
                    int length = objArr.length;
                }
            }
            if ((jSONObject.has("extraHigh") ? 19 : 'H') == 19) {
                int i3 = Cardinal;
                int i4 = (i3 | 89) << 1;
                int i5 = -(((~i3) & 89) | (i3 & -90));
                int i6 = (i4 ^ i5) + ((i5 & i4) << 1);
                cleanup = i6 % 128;
                if (!(i6 % 2 != 0)) {
                    this.cca_continue = jSONObject.optString("extraHigh", "");
                    int i7 = 18 / 0;
                } else {
                    this.cca_continue = jSONObject.optString("extraHigh", "");
                }
            }
            if ((jSONObject.has("high") ? 'B' : ' ') != ' ') {
                int i8 = Cardinal + 85;
                cleanup = i8 % 128;
                if (i8 % 2 == 0) {
                    this.configure = jSONObject.optString("high", "");
                    int length2 = objArr.length;
                } else {
                    this.configure = jSONObject.optString("high", "");
                }
            }
            int i9 = Cardinal;
            int i10 = ((((i9 | 76) << 1) - (i9 ^ 76)) - 0) - 1;
            cleanup = i10 % 128;
            int i11 = i10 % 2;
            int i12 = cleanup;
            int i13 = ((i12 | 31) << 1) - (i12 ^ 31);
            Cardinal = i13 % 128;
            boolean z2 = (i13 % 2 != 0 ? IOUtils.DIR_SEPARATOR_UNIX : '!') != '/';
            int i14 = Cardinal + 43;
            cleanup = i14 % 128;
            if (i14 % 2 == 0) {
                z = false;
            }
            if (z) {
                return z2;
            }
            int i15 = 49 / 0;
            return z2;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r13 != 4) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r13 != 4) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String cca_continue(android.content.Context r13) {
        /*
            r12 = this;
            int r0 = Cardinal
            r1 = 11
            r2 = r0 ^ 11
            r3 = r0 & 11
            r2 = r2 | r3
            r3 = 1
            int r2 = r2 << r3
            r4 = r0 & -12
            int r0 = ~r0
            r0 = r0 & r1
            r0 = r0 | r4
            int r0 = -r0
            int r0 = ~r0
            int r2 = r2 - r0
            int r2 = r2 - r3
            int r0 = r2 % 128
            cleanup = r0
            r0 = 2
            int r2 = r2 % r0
            r4 = 0
            if (r2 != 0) goto L_0x001f
            r2 = 0
            goto L_0x0020
        L_0x001f:
            r2 = 1
        L_0x0020:
            r5 = 0
            r6 = 15
            r7 = 4
            r8 = 3
            r9 = 5
            java.lang.String r10 = ""
            r11 = 95
            if (r2 == 0) goto L_0x003e
            android.content.res.Resources r13 = r13.getResources()
            android.content.res.Configuration r13 = r13.getConfiguration()
            int r13 = r13.screenLayout
            r13 = r13 & r6
            if (r13 == r0) goto L_0x014e
            if (r13 == r8) goto L_0x00b4
            if (r13 == r7) goto L_0x00b4
            goto L_0x0053
        L_0x003e:
            android.content.res.Resources r13 = r13.getResources()
            android.content.res.Configuration r13 = r13.getConfiguration()
            int r13 = r13.screenLayout
            r2 = r13 ^ 86
            r13 = r13 & 86
            r13 = r13 | r2
            if (r13 == r0) goto L_0x014e
            if (r13 == r8) goto L_0x00b4
            if (r13 == r7) goto L_0x00b4
        L_0x0053:
            java.lang.String r13 = r12.getInstance
            r2 = 8
            if (r13 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r11 = 8
        L_0x005c:
            if (r11 == r2) goto L_0x009a
            int r13 = Cardinal
            r2 = r13 & 97
            r13 = r13 ^ 97
            r13 = r13 | r2
            r5 = r2 ^ r13
            r13 = r13 & r2
            int r13 = r13 << r3
            int r5 = r5 + r13
            int r13 = r5 % 128
            cleanup = r13
            int r5 = r5 % r0
            if (r5 != 0) goto L_0x0073
            r13 = 0
            goto L_0x0074
        L_0x0073:
            r13 = 1
        L_0x0074:
            if (r13 == 0) goto L_0x007a
            java.lang.String r13 = r12.getInstance
        L_0x0078:
            r10 = r13
            goto L_0x0080
        L_0x007a:
            java.lang.String r13 = r12.getInstance
            r2 = 71
            int r2 = r2 / r4
            goto L_0x0078
        L_0x0080:
            int r13 = cleanup
            r2 = r13 ^ 11
            r4 = r13 & 11
            r2 = r2 | r4
            int r2 = r2 << r3
            r4 = r13 & -12
            int r13 = ~r13
            r13 = r13 & r1
            r13 = r13 | r4
            int r13 = -r13
            r1 = r2 & r13
            r13 = r13 | r2
            int r1 = r1 + r13
            int r13 = r1 % 128
            Cardinal = r13
            int r1 = r1 % r0
            goto L_0x00a3
        L_0x0098:
            r13 = move-exception
            throw r13
        L_0x009a:
            int r13 = cleanup
            int r13 = r13 + 9
            int r1 = r13 % 128
            Cardinal = r1
            int r13 = r13 % r0
        L_0x00a3:
            int r13 = Cardinal
            int r13 = r13 + 20
            r1 = r13 ^ -1
            r13 = r13 & -1
            int r13 = r13 << r3
        L_0x00ac:
            int r1 = r1 + r13
            int r13 = r1 % 128
            cleanup = r13
            int r1 = r1 % r0
            goto L_0x01e4
        L_0x00b4:
            java.lang.String r13 = r12.cca_continue
            if (r13 == 0) goto L_0x00ba
            r13 = 0
            goto L_0x00bb
        L_0x00ba:
            r13 = 1
        L_0x00bb:
            if (r13 == 0) goto L_0x0129
            java.lang.String r13 = r12.configure
            if (r13 == 0) goto L_0x00c3
            r13 = 1
            goto L_0x00c4
        L_0x00c3:
            r13 = 0
        L_0x00c4:
            if (r13 == 0) goto L_0x00ed
            int r13 = cleanup
            r1 = r13 & 111(0x6f, float:1.56E-43)
            r13 = r13 | 111(0x6f, float:1.56E-43)
            int r13 = -r13
            int r13 = -r13
            r2 = r1 | r13
            int r2 = r2 << r3
            r13 = r13 ^ r1
            int r2 = r2 - r13
            int r13 = r2 % 128
            Cardinal = r13
            int r2 = r2 % r0
            java.lang.String r10 = r12.configure
            int r13 = Cardinal
            r1 = r13 & 5
            int r2 = ~r1
            r13 = r13 | r9
            r13 = r13 & r2
            int r1 = r1 << r3
            r2 = r13 | r1
            int r2 = r2 << r3
            r13 = r13 ^ r1
            int r2 = r2 - r13
            int r13 = r2 % 128
            cleanup = r13
        L_0x00eb:
            int r2 = r2 % r0
            goto L_0x0144
        L_0x00ed:
            java.lang.String r13 = r12.getInstance
            if (r13 == 0) goto L_0x00f2
            r4 = 1
        L_0x00f2:
            if (r4 == r3) goto L_0x0107
            int r13 = cleanup
            r1 = r13 & 7
            r13 = r13 ^ 7
            r13 = r13 | r1
            int r13 = -r13
            int r13 = -r13
            r2 = r1 | r13
            int r2 = r2 << r3
            r13 = r13 ^ r1
            int r2 = r2 - r13
            int r13 = r2 % 128
            Cardinal = r13
            goto L_0x00eb
        L_0x0107:
            int r13 = Cardinal
            r1 = r13 ^ 91
            r13 = r13 & 91
            int r13 = r13 << r3
            int r1 = r1 + r13
            int r13 = r1 % 128
            cleanup = r13
            int r1 = r1 % r0
            java.lang.String r10 = r12.getInstance
            int r13 = cleanup
            r1 = r13 & 56
            r13 = r13 | 56
            int r1 = r1 + r13
            r13 = r1 ^ -1
            r1 = r1 & -1
            int r1 = r1 << r3
            int r13 = r13 + r1
            int r1 = r13 % 128
            Cardinal = r1
            int r13 = r13 % r0
            goto L_0x0144
        L_0x0129:
            int r13 = Cardinal
            r1 = r13 & 95
            r13 = r13 ^ r11
            r13 = r13 | r1
            int r13 = ~r13
            int r1 = r1 - r13
            int r1 = r1 - r3
            int r13 = r1 % 128
            cleanup = r13
            int r1 = r1 % r0
            if (r1 != 0) goto L_0x013a
            r3 = 0
        L_0x013a:
            if (r3 == 0) goto L_0x0140
            java.lang.String r13 = r12.cca_continue
        L_0x013e:
            r10 = r13
            goto L_0x0144
        L_0x0140:
            java.lang.String r13 = r12.cca_continue
            int r1 = r5.length     // Catch:{ all -> 0x014c }
            goto L_0x013e
        L_0x0144:
            int r13 = Cardinal
            r1 = r13 & 125(0x7d, float:1.75E-43)
            r13 = r13 | 125(0x7d, float:1.75E-43)
            goto L_0x00ac
        L_0x014c:
            r13 = move-exception
            throw r13
        L_0x014e:
            java.lang.String r13 = r12.configure
            r1 = 16
            if (r13 == 0) goto L_0x0157
            r13 = 44
            goto L_0x0159
        L_0x0157:
            r13 = 16
        L_0x0159:
            if (r13 == r1) goto L_0x0181
            int r13 = Cardinal
            r1 = r13 & 29
            r13 = r13 | 29
            int r13 = ~r13
            int r1 = r1 - r13
            int r1 = r1 - r3
            int r13 = r1 % 128
            cleanup = r13
            int r1 = r1 % r0
            java.lang.String r10 = r12.configure
            int r13 = cleanup
            r1 = 67
            r2 = r13 ^ 67
            r4 = r13 & 67
            r2 = r2 | r4
            int r2 = r2 << r3
            r4 = r13 & -68
            int r13 = ~r13
            r13 = r13 & r1
            r13 = r13 | r4
            int r2 = r2 - r13
            int r13 = r2 % 128
            Cardinal = r13
            int r2 = r2 % r0
            goto L_0x01ce
        L_0x0181:
            java.lang.String r13 = r12.getInstance
            r1 = 31
            if (r13 == 0) goto L_0x0189
            r13 = 5
            goto L_0x018b
        L_0x0189:
            r13 = 31
        L_0x018b:
            if (r13 == r9) goto L_0x019f
            int r13 = cleanup
            r1 = r13 ^ 95
            r2 = r13 & 95
            r1 = r1 | r2
            int r1 = r1 << r3
            int r2 = ~r2
            r13 = r13 | r11
            r13 = r13 & r2
            int r1 = r1 - r13
        L_0x0199:
            int r13 = r1 % 128
            Cardinal = r13
            int r1 = r1 % r0
            goto L_0x01ce
        L_0x019f:
            int r13 = Cardinal
            r2 = r13 | 33
            int r2 = r2 << r3
            r4 = r13 & -34
            int r13 = ~r13
            r13 = r13 & 33
            r13 = r13 | r4
            int r13 = -r13
            r4 = r2 | r13
            int r4 = r4 << r3
            r13 = r13 ^ r2
            int r4 = r4 - r13
            int r13 = r4 % 128
            cleanup = r13
            int r4 = r4 % r0
            if (r4 != 0) goto L_0x01b8
            goto L_0x01ba
        L_0x01b8:
            r6 = 31
        L_0x01ba:
            if (r6 == r1) goto L_0x01c2
            java.lang.String r13 = r12.getInstance
            int r1 = r5.length     // Catch:{ all -> 0x01c0 }
            goto L_0x01c4
        L_0x01c0:
            r13 = move-exception
            throw r13
        L_0x01c2:
            java.lang.String r13 = r12.getInstance
        L_0x01c4:
            r10 = r13
            int r13 = cleanup
            r1 = r13 ^ 61
            r13 = r13 & 61
            int r13 = r13 << r3
            int r1 = r1 + r13
            goto L_0x0199
        L_0x01ce:
            int r13 = cleanup
            r1 = r13 | 115(0x73, float:1.61E-43)
            int r1 = r1 << r3
            r2 = r13 & -116(0xffffffffffffff8c, float:NaN)
            int r13 = ~r13
            r13 = r13 & 115(0x73, float:1.61E-43)
            r13 = r13 | r2
            int r13 = -r13
            r2 = r1 ^ r13
            r13 = r13 & r1
            int r13 = r13 << r3
            int r2 = r2 + r13
            int r13 = r2 % 128
            Cardinal = r13
            int r2 = r2 % r0
        L_0x01e4:
            int r13 = Cardinal
            r1 = r13 & 85
            r13 = r13 ^ 85
            r13 = r13 | r1
            int r1 = r1 + r13
            int r13 = r1 % 128
            cleanup = r13
            int r1 = r1 % r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setLinkTextColor.cca_continue(android.content.Context):java.lang.String");
    }
}
