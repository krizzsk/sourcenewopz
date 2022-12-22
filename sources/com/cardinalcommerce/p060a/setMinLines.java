package com.cardinalcommerce.p060a;

import java.io.Serializable;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setMinLines */
public final class setMinLines implements Serializable {
    private static int configure = 0;
    private static int getSDKVersion = 1;
    public final String Cardinal;
    public final boolean cca_continue;
    public final String getInstance;
    public final String init;

    public setMinLines() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if ((r4.equals("")) != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        if ((!r4.equals("") ? 'K' : org.osgi.framework.VersionRange.RIGHT_CLOSED) != 'K') goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0055, code lost:
        if ((r4 == r5 ? '2' : 17) != '2') goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0063, code lost:
        if ((r4 == r5 ? 15 : 'H') != 15) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0065, code lost:
        r4 = getSDKVersion;
        r5 = (r4 & 126) + (r4 | 126);
        r4 = ((r5 | -1) << 1) - (r5 ^ -1);
        configure = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0078, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean cca_continue(java.lang.String r4, int r5) {
        /*
            int r0 = getSDKVersion
            int r0 = r0 + 100
            r1 = 1
            int r0 = r0 - r1
            int r2 = r0 % 128
            configure = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 == 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.String r3 = ""
            if (r0 == r1) goto L_0x0022
            boolean r0 = r4.equals(r3)
            if (r0 != 0) goto L_0x001e
            r0 = 0
            goto L_0x001f
        L_0x001e:
            r0 = 1
        L_0x001f:
            if (r0 == 0) goto L_0x0034
            goto L_0x0065
        L_0x0022:
            boolean r0 = r4.equals(r3)
            r3 = 5
            int r3 = r3 / r2
            r3 = 75
            if (r0 != 0) goto L_0x002f
            r0 = 75
            goto L_0x0031
        L_0x002f:
            r0 = 93
        L_0x0031:
            if (r0 == r3) goto L_0x0034
            goto L_0x0065
        L_0x0034:
            int r0 = configure
            int r0 = r0 + 69
            int r3 = r0 % 128
            getSDKVersion = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            int r4 = r4.length()
            if (r0 == 0) goto L_0x005a
            r0 = 11
            int r0 = r0 / r2
            r0 = 50
            if (r4 != r5) goto L_0x0053
            r4 = 50
            goto L_0x0055
        L_0x0053:
            r4 = 17
        L_0x0055:
            if (r4 == r0) goto L_0x0079
            goto L_0x0065
        L_0x0058:
            r4 = move-exception
            throw r4
        L_0x005a:
            r0 = 15
            if (r4 != r5) goto L_0x0061
            r4 = 15
            goto L_0x0063
        L_0x0061:
            r4 = 72
        L_0x0063:
            if (r4 == r0) goto L_0x0079
        L_0x0065:
            int r4 = getSDKVersion
            r5 = r4 & 126(0x7e, float:1.77E-43)
            r4 = r4 | 126(0x7e, float:1.77E-43)
            int r5 = r5 + r4
            r4 = r5 | -1
            int r4 = r4 << r1
            r5 = r5 ^ -1
            int r4 = r4 - r5
            int r5 = r4 % 128
            configure = r5
            int r4 = r4 % 2
            return r2
        L_0x0079:
            int r4 = getSDKVersion
            int r4 = r4 + 95
            int r4 = r4 - r1
            int r4 = r4 - r2
            int r4 = r4 - r1
            int r5 = r4 % 128
            configure = r5
            int r4 = r4 % 2
            r5 = 68
            if (r4 == 0) goto L_0x008d
            r4 = 68
            goto L_0x008f
        L_0x008d:
            r4 = 24
        L_0x008f:
            if (r4 == r5) goto L_0x0092
            return r1
        L_0x0092:
            r4 = 0
            super.hashCode()     // Catch:{ all -> 0x0097 }
            return r1
        L_0x0097:
            r4 = move-exception
            throw r4
        L_0x0099:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setMinLines.cca_continue(java.lang.String, int):boolean");
    }

    public static boolean init(String str) {
        int i = configure;
        int i2 = i ^ 83;
        int i3 = ((i & 83) | i2) << 1;
        int i4 = -i2;
        int i5 = (i3 & i4) + (i3 | i4);
        getSDKVersion = i5 % 128;
        int i6 = i5 % 2;
        if (str.equals("")) {
            int i7 = (configure + 62) - 1;
            getSDKVersion = i7 % 128;
            if ((i7 % 2 == 0 ? 27 : '0') == '0') {
                return false;
            }
            int i8 = 67 / 0;
            return false;
        }
        int i9 = configure;
        int i10 = i9 & 119;
        int i11 = (((i9 | 119) & (~i10)) - (~(-(-(i10 << 1))))) - 1;
        getSDKVersion = i11 % 128;
        if (i11 % 2 == 0) {
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        if ((!r0 ? 25 : '+') != '+') goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        if ((r8.equals("")) != true) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ba, code lost:
        r8 = configure;
        r9 = (r8 ^ 93) + ((r8 & 93) << 1);
        getSDKVersion = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c8, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean configure(java.lang.String r8, int r9) {
        /*
            int r0 = getSDKVersion
            r1 = r0 ^ 57
            r0 = r0 & 57
            r2 = 1
            int r0 = r0 << r2
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            configure = r0
            int r1 = r1 % 2
            r0 = 89
            if (r1 == 0) goto L_0x0018
            r1 = 48
            goto L_0x001a
        L_0x0018:
            r1 = 89
        L_0x001a:
            java.lang.String r3 = ""
            r4 = 0
            r5 = 0
            if (r1 == r0) goto L_0x0035
            boolean r0 = r8.equals(r3)
            super.hashCode()     // Catch:{ all -> 0x0033 }
            r1 = 43
            if (r0 != 0) goto L_0x002e
            r0 = 25
            goto L_0x0030
        L_0x002e:
            r0 = 43
        L_0x0030:
            if (r0 == r1) goto L_0x00ba
            goto L_0x0040
        L_0x0033:
            r8 = move-exception
            throw r8
        L_0x0035:
            boolean r0 = r8.equals(r3)
            if (r0 != 0) goto L_0x003d
            r0 = 0
            goto L_0x003e
        L_0x003d:
            r0 = 1
        L_0x003e:
            if (r0 == r2) goto L_0x00ba
        L_0x0040:
            int r8 = r8.length()
            double r0 = (double) r8
            double r8 = (double) r9
            r6 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r8 = r8 * r6
            r3 = 56
            int r6 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x0056
            r8 = 56
            goto L_0x0058
        L_0x0056:
            r8 = 84
        L_0x0058:
            if (r8 == r3) goto L_0x007c
            int r8 = configure
            r9 = r8 & 21
            int r0 = ~r9
            r8 = r8 | 21
            r8 = r8 & r0
            int r9 = r9 << r2
            int r9 = ~r9
            int r8 = r8 - r9
            int r8 = r8 - r2
            int r9 = r8 % 128
            getSDKVersion = r9
            int r8 = r8 % 2
            r9 = 73
            if (r8 != 0) goto L_0x0073
            r8 = 73
            goto L_0x0075
        L_0x0073:
            r8 = 54
        L_0x0075:
            if (r8 == r9) goto L_0x0078
            return r5
        L_0x0078:
            int r8 = r4.length     // Catch:{ all -> 0x007a }
            return r5
        L_0x007a:
            r8 = move-exception
            throw r8
        L_0x007c:
            int r8 = configure
            r9 = r8 ^ 56
            r8 = r8 & r3
            int r8 = r8 << r2
            int r9 = r9 + r8
            r8 = r9 & -1
            r9 = r9 | -1
            int r8 = r8 + r9
            int r9 = r8 % 128
            getSDKVersion = r9
            int r8 = r8 % 2
            if (r8 != 0) goto L_0x0092
            r8 = 0
            goto L_0x0093
        L_0x0092:
            r8 = 1
        L_0x0093:
            if (r8 == r2) goto L_0x0097
            r8 = 0
            goto L_0x0098
        L_0x0097:
            r8 = 1
        L_0x0098:
            int r9 = configure
            r0 = 81
            r1 = r9 ^ 81
            r3 = r9 & 81
            r1 = r1 | r3
            int r1 = r1 << r2
            r3 = r9 & -82
            int r9 = ~r9
            r9 = r9 & r0
            r9 = r9 | r3
            int r1 = r1 - r9
            int r9 = r1 % 128
            getSDKVersion = r9
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x00b1
            r5 = 1
        L_0x00b1:
            if (r5 == r2) goto L_0x00b4
            return r8
        L_0x00b4:
            super.hashCode()     // Catch:{ all -> 0x00b8 }
            return r8
        L_0x00b8:
            r8 = move-exception
            throw r8
        L_0x00ba:
            int r8 = configure
            r9 = r8 ^ 93
            r8 = r8 & 93
            int r8 = r8 << r2
            int r9 = r9 + r8
            int r8 = r9 % 128
            getSDKVersion = r8
            int r9 = r9 % 2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setMinLines.configure(java.lang.String, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if ((r1 ? 'Y' : 2) != 2) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if ((r9.equals("") ? org.apache.commons.p071io.IOUtils.DIR_SEPARATOR_UNIX : '^') != '/') goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0083, code lost:
        if ((((double) r9.length()) > ((double) r10) / 1.2d) != true) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
        if ((((double) r9.length()) <= ((double) r10) * 1.2d ? 0 : '%') != '%') goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c0, code lost:
        r9 = configure;
        r1 = r9 & 55;
        r10 = ((r9 ^ 55) | r1) << 1;
        r9 = -((r9 | 55) & (~r1));
        r1 = (r10 & r9) + (r9 | r10);
        getSDKVersion = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d6, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00eb, code lost:
        r9 = getSDKVersion + 3;
        configure = r9 % 128;
        r9 = r9 % 2;
        r9 = (((getSDKVersion + 95) - 1) - 0) - 1;
        configure = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0100, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean init(java.lang.String r9, int r10) {
        /*
            int r0 = getSDKVersion
            r1 = r0 ^ 11
            r2 = r0 & 11
            r1 = r1 | r2
            r3 = 1
            int r1 = r1 << r3
            int r2 = ~r2
            r0 = r0 | 11
            r0 = r0 & r2
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r3
            int r0 = r1 % 128
            configure = r0
            r0 = 2
            int r1 = r1 % r0
            r2 = 23
            r4 = 0
            if (r1 == 0) goto L_0x001e
            r1 = 0
            goto L_0x0020
        L_0x001e:
            r1 = 23
        L_0x0020:
            r5 = 0
            java.lang.String r6 = ""
            if (r1 == r2) goto L_0x0038
            boolean r1 = r9.equals(r6)
            super.hashCode()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0031
            r1 = 89
            goto L_0x0032
        L_0x0031:
            r1 = 2
        L_0x0032:
            if (r1 == r0) goto L_0x0047
            goto L_0x00eb
        L_0x0036:
            r9 = move-exception
            throw r9
        L_0x0038:
            boolean r1 = r9.equals(r6)
            r2 = 47
            if (r1 == 0) goto L_0x0043
            r1 = 47
            goto L_0x0045
        L_0x0043:
            r1 = 94
        L_0x0045:
            if (r1 == r2) goto L_0x00eb
        L_0x0047:
            boolean r1 = r9.equals(r6)
            if (r1 != 0) goto L_0x004f
            r1 = 0
            goto L_0x0050
        L_0x004f:
            r1 = 1
        L_0x0050:
            if (r1 == r3) goto L_0x00d7
            int r1 = configure
            r2 = r1 & 117(0x75, float:1.64E-43)
            r1 = r1 ^ 117(0x75, float:1.64E-43)
            r1 = r1 | r2
            r6 = r2 | r1
            int r6 = r6 << r3
            r1 = r1 ^ r2
            int r6 = r6 - r1
            int r1 = r6 % 128
            getSDKVersion = r1
            int r6 = r6 % r0
            r1 = 56
            if (r6 != 0) goto L_0x006a
            r2 = 42
            goto L_0x006c
        L_0x006a:
            r2 = 56
        L_0x006c:
            r6 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            r8 = 37
            if (r2 == r1) goto L_0x0086
            int r9 = r9.length()
            double r1 = (double) r9
            double r9 = (double) r10
            double r9 = r9 / r6
            int r6 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x0082
            r9 = 0
            goto L_0x0083
        L_0x0082:
            r9 = 1
        L_0x0083:
            if (r9 == r3) goto L_0x00c0
            goto L_0x0098
        L_0x0086:
            int r9 = r9.length()
            double r1 = (double) r9
            double r9 = (double) r10
            double r9 = r9 * r6
            int r6 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x0094
            r9 = 0
            goto L_0x0096
        L_0x0094:
            r9 = 37
        L_0x0096:
            if (r9 == r8) goto L_0x00c0
        L_0x0098:
            int r9 = configure
            r10 = r9 | 51
            int r10 = r10 << r3
            r9 = r9 ^ 51
            int r9 = -r9
            r1 = r10 & r9
            r9 = r9 | r10
            int r1 = r1 + r9
            int r9 = r1 % 128
            getSDKVersion = r9
            int r1 = r1 % r0
            int r9 = getSDKVersion
            r10 = r9 & 37
            r9 = r9 | r8
            int r9 = ~r9
            int r10 = r10 - r9
            int r10 = r10 - r3
            int r9 = r10 % 128
            configure = r9
            int r10 = r10 % r0
            if (r10 == 0) goto L_0x00b9
            r4 = 1
        L_0x00b9:
            if (r4 == 0) goto L_0x00bf
            int r9 = r5.length     // Catch:{ all -> 0x00bd }
            return r3
        L_0x00bd:
            r9 = move-exception
            throw r9
        L_0x00bf:
            return r3
        L_0x00c0:
            int r9 = configure
            r10 = r9 ^ 55
            r1 = r9 & 55
            r10 = r10 | r1
            int r10 = r10 << r3
            int r1 = ~r1
            r9 = r9 | 55
            r9 = r9 & r1
            int r9 = -r9
            r1 = r10 & r9
            r9 = r9 | r10
            int r1 = r1 + r9
            int r9 = r1 % 128
            getSDKVersion = r9
            int r1 = r1 % r0
            return r4
        L_0x00d7:
            int r9 = getSDKVersion
            r10 = r9 ^ 77
            r9 = r9 & 77
            r9 = r9 | r10
            int r9 = r9 << r3
            int r10 = -r10
            r1 = r9 | r10
            int r1 = r1 << r3
            r9 = r9 ^ r10
            int r1 = r1 - r9
            int r9 = r1 % 128
            configure = r9
            int r1 = r1 % r0
            return r4
        L_0x00eb:
            int r9 = getSDKVersion
            int r9 = r9 + 3
            int r10 = r9 % 128
            configure = r10
            int r9 = r9 % r0
            int r9 = getSDKVersion
            int r9 = r9 + 95
            int r9 = r9 - r3
            int r9 = r9 - r4
            int r9 = r9 - r3
            int r10 = r9 % 128
            configure = r10
            int r9 = r9 % r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setMinLines.init(java.lang.String, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if ((r5.equals("")) != true) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        if ((!r5.equals("")) != true) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        if (r5.equals("") != false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0075, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0076, code lost:
        if (r5 == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0078, code lost:
        r5 = ((configure + 29) - 1) - 1;
        getSDKVersion = r5 % 128;
        r5 = r5 % 2;
        r5 = configure;
        r0 = (((r5 & 26) + (r5 | 26)) - 0) - 1;
        getSDKVersion = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0093, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        r5 = getSDKVersion;
        r0 = r5 & 15;
        r5 = -(-((r5 ^ 15) | r0));
        r1 = (r0 ^ r5) + ((r5 & r0) << 1);
        configure = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getInstance(java.lang.String r5) {
        /*
            int r0 = getSDKVersion
            r1 = r0 ^ 39
            r2 = r0 & 39
            r1 = r1 | r2
            r3 = 1
            int r1 = r1 << r3
            int r2 = ~r2
            r0 = r0 | 39
            r0 = r0 & r2
            int r0 = -r0
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            configure = r0
            int r2 = r2 % 2
            r0 = 25
            if (r2 == 0) goto L_0x001f
            r1 = 73
            goto L_0x0021
        L_0x001f:
            r1 = 25
        L_0x0021:
            java.lang.String r2 = ""
            r4 = 0
            if (r1 == r0) goto L_0x0037
            boolean r0 = r5.equals(r2)
            r1 = 38
            int r1 = r1 / r4
            if (r0 == 0) goto L_0x0031
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            if (r0 == r3) goto L_0x0042
            goto L_0x006d
        L_0x0035:
            r5 = move-exception
            throw r5
        L_0x0037:
            boolean r0 = r5.equals(r2)
            if (r0 == 0) goto L_0x003f
            r0 = 0
            goto L_0x0040
        L_0x003f:
            r0 = 1
        L_0x0040:
            if (r0 == r3) goto L_0x006d
        L_0x0042:
            int r5 = configure
            int r5 = r5 + 102
            int r5 = r5 - r3
            int r0 = r5 % 128
            getSDKVersion = r0
            int r5 = r5 % 2
            int r5 = getSDKVersion
            r0 = r5 ^ 58
            r5 = r5 & 58
            int r5 = r5 << r3
            int r0 = r0 + r5
            int r0 = r0 - r3
            int r5 = r0 % 128
            configure = r5
            int r0 = r0 % 2
            r5 = 55
            if (r0 == 0) goto L_0x0063
            r0 = 98
            goto L_0x0065
        L_0x0063:
            r0 = 55
        L_0x0065:
            if (r0 == r5) goto L_0x006c
            r5 = 0
            int r5 = r5.length     // Catch:{ all -> 0x006a }
            return r4
        L_0x006a:
            r5 = move-exception
            throw r5
        L_0x006c:
            return r4
        L_0x006d:
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x0075
            r5 = 1
            goto L_0x0076
        L_0x0075:
            r5 = 0
        L_0x0076:
            if (r5 == 0) goto L_0x0094
            int r5 = configure
            int r5 = r5 + 29
            int r5 = r5 - r3
            int r5 = r5 - r3
            int r0 = r5 % 128
            getSDKVersion = r0
            int r5 = r5 % 2
            int r5 = configure
            r0 = r5 & 26
            r5 = r5 | 26
            int r0 = r0 + r5
            int r0 = r0 - r4
            int r0 = r0 - r3
            int r5 = r0 % 128
            getSDKVersion = r5
            int r0 = r0 % 2
            return r3
        L_0x0094:
            int r5 = getSDKVersion
            r0 = r5 & 15
            r5 = r5 ^ 15
            r5 = r5 | r0
            int r5 = -r5
            int r5 = -r5
            r1 = r0 ^ r5
            r5 = r5 & r0
            int r5 = r5 << r3
            int r1 = r1 + r5
            int r5 = r1 % 128
            configure = r5
            int r1 = r1 % 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setMinLines.getInstance(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        if ((getInstance(r10, 1) ? org.osgi.framework.VersionRange.LEFT_OPEN : 18) != '(') goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r0 = configure;
        r3 = (((r0 ^ 15) | (r0 & 15)) << 1) - (((~r0) & 15) | (r0 & -16));
        getSDKVersion = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        if ((r3 % 2) != 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r0 = configure;
        r3 = ((((r0 | 36) << 1) - (r0 ^ 36)) - 0) - 1;
        getSDKVersion = r3 % 128;
        r3 = r3 % 2;
        r0 = 0;
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008c, code lost:
        if (r0 >= 2) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        r7 = 'X';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        r7 = '_';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0093, code lost:
        if (r7 == '_') goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0095, code lost:
        r6 = getSDKVersion;
        r7 = (r6 ^ 113) + ((r6 & 113) << 1);
        configure = r7 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a4, code lost:
        if ((r7 % 2) == 0) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        r7 = '=';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a9, code lost:
        r7 = ';';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ab, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ac, code lost:
        if (r7 == ';') goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ae, code lost:
        r6 = r11[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b3, code lost:
        if (r3 != false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b5, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b7, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b8, code lost:
        if (r7 == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00bd, code lost:
        r6 = r11[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c1, code lost:
        if (r3 != false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c3, code lost:
        r9 = 'T';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c6, code lost:
        r9 = 'N';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c8, code lost:
        if (r9 == 'T') goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cb, code lost:
        r3 = configure;
        r7 = (r3 ^ 13) + ((r3 & 13) << 1);
        getSDKVersion = r7 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00da, code lost:
        if ((r7 % 2) != 0) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00dc, code lost:
        r7 = org.apache.commons.p071io.IOUtils.DIR_SEPARATOR_UNIX;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00df, code lost:
        r7 = '4';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e1, code lost:
        if (r7 == '/') goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e3, code lost:
        r3 = r10.equalsIgnoreCase(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e8, code lost:
        r3 = r10.equalsIgnoreCase(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r6 = r8.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ed, code lost:
        r6 = ((r0 ^ -47) | (r0 & -47)) << 1;
        r0 = -(((~r0) & -47) | (r0 & 46));
        r7 = (r6 ^ r0) + ((r0 & r6) << 1);
        r6 = r7 & 48;
        r0 = ((r7 ^ 48) | r6) << 1;
        r6 = -((~r6) & (r7 | 48));
        r0 = ((r0 & r6) << 1) + (r0 ^ r6);
        r6 = getSDKVersion;
        r7 = ((r6 ^ 88) + ((88 & r6) << 1)) - 1;
        configure = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0120, code lost:
        r10 = configure;
        r0 = r10 & 1;
        r11 = ((r10 ^ 1) | r0) << 1;
        r10 = -((r10 | 1) & (~r0));
        r0 = (r11 ^ r10) + ((r10 & r11) << 1);
        getSDKVersion = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0136, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r3 != 'O') goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Cardinal(java.lang.String r10, java.lang.String[] r11) {
        /*
            int r0 = configure
            r1 = r0 & 19
            int r2 = ~r1
            r0 = r0 | 19
            r0 = r0 & r2
            r2 = 1
            int r1 = r1 << r2
            int r1 = -r1
            int r1 = -r1
            int r1 = ~r1
            int r0 = r0 - r1
            int r0 = r0 - r2
            int r1 = r0 % 128
            getSDKVersion = r1
            r1 = 2
            int r0 = r0 % r1
            r3 = 91
            r4 = 15
            if (r0 != 0) goto L_0x001e
            r0 = 15
            goto L_0x0020
        L_0x001e:
            r0 = 91
        L_0x0020:
            r5 = 0
            if (r0 == r4) goto L_0x0030
            boolean r0 = getInstance(r10, r2)
            r6 = 79
            if (r0 == 0) goto L_0x002d
            r3 = 79
        L_0x002d:
            if (r3 == r6) goto L_0x005d
            goto L_0x003f
        L_0x0030:
            boolean r0 = getInstance(r10, r2)
            r3 = 40
            if (r0 == 0) goto L_0x003b
            r0 = 40
            goto L_0x003d
        L_0x003b:
            r0 = 18
        L_0x003d:
            if (r0 == r3) goto L_0x005d
        L_0x003f:
            int r10 = configure
            r11 = r10 & 44
            r10 = r10 | 44
            int r11 = r11 + r10
            int r11 = r11 - r2
            int r10 = r11 % 128
            getSDKVersion = r10
            int r11 = r11 % r1
            r10 = 31
            if (r11 != 0) goto L_0x0053
            r11 = 31
            goto L_0x0054
        L_0x0053:
            r11 = 6
        L_0x0054:
            if (r11 == r10) goto L_0x0057
            return r5
        L_0x0057:
            r10 = 95
            int r10 = r10 / r5
            return r5
        L_0x005b:
            r10 = move-exception
            throw r10
        L_0x005d:
            int r0 = configure
            r3 = r0 ^ 15
            r6 = r0 & 15
            r3 = r3 | r6
            int r3 = r3 << r2
            r6 = r0 & -16
            int r0 = ~r0
            r0 = r0 & r4
            r0 = r0 | r6
            int r3 = r3 - r0
            int r0 = r3 % 128
            getSDKVersion = r0
            int r3 = r3 % r1
            r0 = 7
            if (r3 != 0) goto L_0x0075
            r3 = 7
            goto L_0x0077
        L_0x0075:
            r3 = 23
        L_0x0077:
            int r0 = configure
            r3 = r0 | 36
            int r3 = r3 << r2
            r0 = r0 ^ 36
            int r3 = r3 - r0
            int r3 = r3 - r5
            int r3 = r3 - r2
            int r0 = r3 % 128
            getSDKVersion = r0
            int r3 = r3 % r1
            r0 = 0
            r3 = 0
        L_0x0088:
            r4 = 88
            r6 = 95
            if (r0 >= r1) goto L_0x0091
            r7 = 88
            goto L_0x0093
        L_0x0091:
            r7 = 95
        L_0x0093:
            if (r7 == r6) goto L_0x0120
            int r6 = getSDKVersion
            r7 = r6 ^ 113(0x71, float:1.58E-43)
            r6 = r6 & 113(0x71, float:1.58E-43)
            int r6 = r6 << r2
            int r7 = r7 + r6
            int r6 = r7 % 128
            configure = r6
            int r7 = r7 % r1
            r6 = 59
            if (r7 == 0) goto L_0x00a9
            r7 = 61
            goto L_0x00ab
        L_0x00a9:
            r7 = 59
        L_0x00ab:
            r8 = 0
            if (r7 == r6) goto L_0x00bd
            r6 = r11[r0]
            super.hashCode()     // Catch:{ all -> 0x00bb }
            if (r3 != 0) goto L_0x00b7
            r7 = 0
            goto L_0x00b8
        L_0x00b7:
            r7 = 1
        L_0x00b8:
            if (r7 == 0) goto L_0x00cb
            goto L_0x00ed
        L_0x00bb:
            r10 = move-exception
            throw r10
        L_0x00bd:
            r6 = r11[r0]
            r7 = 84
            if (r3 != 0) goto L_0x00c6
            r9 = 84
            goto L_0x00c8
        L_0x00c6:
            r9 = 78
        L_0x00c8:
            if (r9 == r7) goto L_0x00cb
            goto L_0x00ed
        L_0x00cb:
            int r3 = configure
            r7 = r3 ^ 13
            r3 = r3 & 13
            int r3 = r3 << r2
            int r7 = r7 + r3
            int r3 = r7 % 128
            getSDKVersion = r3
            int r7 = r7 % r1
            r3 = 47
            if (r7 != 0) goto L_0x00df
            r7 = 47
            goto L_0x00e1
        L_0x00df:
            r7 = 52
        L_0x00e1:
            if (r7 == r3) goto L_0x00e8
            boolean r3 = r10.equalsIgnoreCase(r6)
            goto L_0x00ed
        L_0x00e8:
            boolean r3 = r10.equalsIgnoreCase(r6)
            int r6 = r8.length     // Catch:{ all -> 0x011e }
        L_0x00ed:
            r6 = r0 ^ -47
            r7 = r0 & -47
            r6 = r6 | r7
            int r6 = r6 << r2
            r7 = r0 & 46
            int r0 = ~r0
            r0 = r0 & -47
            r0 = r0 | r7
            int r0 = -r0
            r7 = r6 ^ r0
            r0 = r0 & r6
            int r0 = r0 << r2
            int r7 = r7 + r0
            r0 = r7 ^ 48
            r6 = r7 & 48
            r0 = r0 | r6
            int r0 = r0 << r2
            int r6 = ~r6
            r7 = r7 | 48
            r6 = r6 & r7
            int r6 = -r6
            r7 = r0 ^ r6
            r0 = r0 & r6
            int r0 = r0 << r2
            int r0 = r0 + r7
            int r6 = getSDKVersion
            r7 = r6 ^ 88
            r4 = r4 & r6
            int r4 = r4 << r2
            int r7 = r7 + r4
            int r7 = r7 - r2
            int r4 = r7 % 128
            configure = r4
            int r7 = r7 % r1
            goto L_0x0088
        L_0x011e:
            r10 = move-exception
            throw r10
        L_0x0120:
            int r10 = configure
            r11 = r10 ^ 1
            r0 = r10 & 1
            r11 = r11 | r0
            int r11 = r11 << r2
            int r0 = ~r0
            r10 = r10 | r2
            r10 = r10 & r0
            int r10 = -r10
            r0 = r11 ^ r10
            r10 = r10 & r11
            int r10 = r10 << r2
            int r0 = r0 + r10
            int r10 = r0 % 128
            getSDKVersion = r10
            int r0 = r0 % r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setMinLines.Cardinal(java.lang.String, java.lang.String[]):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        if ((r5 != r6) != false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        if ((r5 == r6 ? (char) 14 : 6) != 14) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009c, code lost:
        r5 = getSDKVersion;
        r6 = r5 & 51;
        r5 = -(-(r5 | 51));
        r0 = (r6 ^ r5) + ((r5 & r6) << 1);
        configure = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        if ((r0 % 2) == 0) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b2, code lost:
        if (r4 == false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b7, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ba, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getInstance(java.lang.String r5, int r6) {
        /*
            int r0 = getSDKVersion
            r1 = 65
            r2 = r0 ^ 65
            r3 = r0 & 65
            r2 = r2 | r3
            r3 = 1
            int r2 = r2 << r3
            r4 = r0 & -66
            int r0 = ~r0
            r0 = r0 & r1
            r0 = r0 | r4
            int r0 = -r0
            r1 = r2 & r0
            r0 = r0 | r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            configure = r0
            int r1 = r1 % 2
            java.lang.String r0 = ""
            boolean r0 = r5.equals(r0)
            r1 = 38
            r2 = 64
            if (r0 != 0) goto L_0x002a
            r0 = 38
            goto L_0x002c
        L_0x002a:
            r0 = 64
        L_0x002c:
            if (r0 == r1) goto L_0x0045
            int r5 = configure
            r6 = r5 & -100
            int r0 = ~r5
            r0 = r0 & 99
            r6 = r6 | r0
            r5 = r5 & 99
            int r5 = r5 << r3
            r0 = r6 | r5
            int r0 = r0 << r3
            r5 = r5 ^ r6
            int r0 = r0 - r5
            int r5 = r0 % 128
            getSDKVersion = r5
            int r0 = r0 % 2
            return r3
        L_0x0045:
            int r0 = getSDKVersion
            r1 = r0 & 59
            r0 = r0 ^ 59
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r4 = r1 | r0
            int r4 = r4 << r3
            r0 = r0 ^ r1
            int r4 = r4 - r0
            int r0 = r4 % 128
            configure = r0
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x005e
            r0 = 46
            goto L_0x0060
        L_0x005e:
            r0 = 64
        L_0x0060:
            r1 = 0
            r4 = 0
            int r5 = r5.length()
            if (r0 == r2) goto L_0x0075
            r0 = 57
            int r0 = r0 / r4
            if (r5 != r6) goto L_0x006f
            r5 = 0
            goto L_0x0070
        L_0x006f:
            r5 = 1
        L_0x0070:
            if (r5 == 0) goto L_0x009c
            goto L_0x007f
        L_0x0073:
            r5 = move-exception
            throw r5
        L_0x0075:
            r0 = 14
            if (r5 != r6) goto L_0x007c
            r5 = 14
            goto L_0x007d
        L_0x007c:
            r5 = 6
        L_0x007d:
            if (r5 == r0) goto L_0x009c
        L_0x007f:
            int r5 = getSDKVersion
            int r5 = r5 + 109
            int r5 = r5 - r3
            r6 = r5 ^ -1
            r5 = r5 & -1
            int r5 = r5 << r3
            int r6 = r6 + r5
            int r5 = r6 % 128
            configure = r5
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x0093
            r3 = 0
        L_0x0093:
            if (r3 == 0) goto L_0x0096
            return r4
        L_0x0096:
            super.hashCode()     // Catch:{ all -> 0x009a }
            return r4
        L_0x009a:
            r5 = move-exception
            throw r5
        L_0x009c:
            int r5 = getSDKVersion
            r6 = r5 & 51
            r5 = r5 | 51
            int r5 = -r5
            int r5 = -r5
            r0 = r6 ^ r5
            r5 = r5 & r6
            int r5 = r5 << r3
            int r0 = r0 + r5
            int r5 = r0 % 128
            configure = r5
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x00b2
            r4 = 1
        L_0x00b2:
            if (r4 == 0) goto L_0x00ba
            super.hashCode()     // Catch:{ all -> 0x00b8 }
            return r3
        L_0x00b8:
            r5 = move-exception
            throw r5
        L_0x00ba:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setMinLines.getInstance(java.lang.String, int):boolean");
    }

    public static boolean Cardinal(String str) {
        int i = (configure + 6) - 1;
        getSDKVersion = i % 128;
        int i2 = i % 2;
        if (str.length() == 36) {
            int i3 = getSDKVersion;
            int i4 = (((i3 ^ 37) | (i3 & 37)) << 1) - (((~i3) & 37) | (i3 & -38));
            configure = i4 % 128;
            int i5 = i4 % 2;
            int i6 = configure;
            int i7 = i6 & 69;
            int i8 = ((i6 ^ 69) | i7) << 1;
            int i9 = -((i6 | 69) & (~i7));
            int i10 = (i8 ^ i9) + ((i9 & i8) << 1);
            getSDKVersion = i10 % 128;
            if ((i10 % 2 == 0 ? '1' : 18) != '1') {
                return true;
            }
            int i11 = 89 / 0;
            return true;
        }
        int i12 = getSDKVersion;
        int i13 = ((i12 | 28) << 1) - (i12 ^ 28);
        int i14 = (i13 ^ -1) + ((i13 & -1) << 1);
        configure = i14 % 128;
        if ((i14 % 2 != 0 ? '2' : 19) == 19) {
            return false;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return false;
    }

    public static boolean cca_continue(String str) {
        int i = configure;
        int i2 = i & 69;
        int i3 = -(-((i ^ 69) | i2));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        getSDKVersion = i4 % 128;
        if (!(i4 % 2 == 0)) {
            return Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$").matcher(str).matches();
        }
        boolean matches = Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$").matcher(str).matches();
        Object obj = null;
        super.hashCode();
        return matches;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
        if (r4.length != 0) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean configure(java.lang.String r4) {
        /*
            int r0 = getSDKVersion
            r1 = r0 ^ 29
            r2 = r0 & 29
            r1 = r1 | r2
            int r1 = r1 << 1
            r2 = r0 & -30
            int r0 = ~r0
            r0 = r0 & 29
            r0 = r0 | r2
            int r1 = r1 - r0
            int r0 = r1 % 128
            configure = r0
            int r1 = r1 % 2
            r0 = 0
            r1 = 8
            byte[] r4 = android.util.Base64.decode(r4, r1)
            r1 = 75
            if (r4 != 0) goto L_0x0024
            r2 = 75
            goto L_0x0026
        L_0x0024:
            r2 = 17
        L_0x0026:
            if (r2 == r1) goto L_0x0029
            goto L_0x0042
        L_0x0029:
            int r1 = configure
            r2 = r1 & 35
            int r3 = ~r2
            r1 = r1 | 35
            r1 = r1 & r3
            int r2 = r2 << 1
            int r2 = -r2
            int r2 = -r2
            int r2 = ~r2
            int r1 = r1 - r2
            int r1 = r1 + -1
            int r2 = r1 % 128
            getSDKVersion = r2
            int r1 = r1 % 2
            int r1 = r4.length
            if (r1 == 0) goto L_0x005c
        L_0x0042:
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8
            r0.<init>(r4, r1)
            int r4 = configure
            int r4 = r4 + 21
            int r4 = r4 + -1
            r1 = r4 | -1
            int r1 = r1 << 1
            r4 = r4 ^ -1
            int r1 = r1 - r4
            int r4 = r1 % 128
            getSDKVersion = r4
            int r1 = r1 % 2
        L_0x005c:
            java.lang.String r4 = "<[a-z/][\\s\\S]*>"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r4 = r4.find()
            int r0 = getSDKVersion
            r1 = r0 ^ 107(0x6b, float:1.5E-43)
            r2 = r0 & 107(0x6b, float:1.5E-43)
            r1 = r1 | r2
            int r1 = r1 << 1
            int r2 = ~r2
            r0 = r0 | 107(0x6b, float:1.5E-43)
            r0 = r0 & r2
            int r1 = r1 - r0
            int r0 = r1 % 128
            configure = r0
            int r1 = r1 % 2
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setMinLines.configure(java.lang.String):boolean");
    }

    public setMinLines(JSONObject jSONObject) {
        this.init = jSONObject.optString("name");
        this.getInstance = jSONObject.optString("id");
        this.cca_continue = jSONObject.optBoolean("criticalityIndicator", true);
        this.Cardinal = jSONObject.optString("data");
    }
}
