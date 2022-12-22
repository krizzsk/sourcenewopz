package com.cardinalcommerce.p060a;

import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.cardinalcommerce.a.setTextAppearance */
public class setTextAppearance {

    /* renamed from: a */
    private static WeakReference<Context> f3002a = null;

    /* renamed from: b */
    private static int f3003b = 0;

    /* renamed from: c */
    private static int f3004c = 1;
    public static boolean getInstance;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.content.Intent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.content.Intent} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void cca_continue(android.content.Context r10, com.cardinalcommerce.p060a.setBaselineAligned r11, com.cardinalcommerce.shared.userinterfaces.UiCustomization r12) {
        /*
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            android.content.Context r1 = r10.getApplicationContext()
            r0.<init>(r1)
            f3002a = r0
            java.lang.String r0 = r11.init
            int r1 = r0.hashCode()
            r2 = 117(0x75, float:1.64E-43)
            r3 = 4
            r4 = 3
            r5 = -1
            r6 = 0
            r7 = 2
            r8 = 1
            switch(r1) {
                case 1537: goto L_0x00e2;
                case 1538: goto L_0x00ba;
                case 1539: goto L_0x008a;
                case 1540: goto L_0x0055;
                case 1541: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x011b
        L_0x001e:
            java.lang.String r1 = "05"
            boolean r0 = r0.equals(r1)
            r1 = 92
            if (r0 == 0) goto L_0x002b
            r0 = 91
            goto L_0x002d
        L_0x002b:
            r0 = 92
        L_0x002d:
            if (r0 == r1) goto L_0x011b
            int r0 = f3003b
            int r0 = r0 + 43
            int r0 = r0 - r8
            int r0 = r0 - r8
            int r1 = r0 % 128
            f3004c = r1
            int r0 = r0 % r7
            if (r0 != 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            int r0 = f3004c
            r1 = r0 ^ 95
            r0 = r0 & 95
            int r0 = r0 << r8
            int r0 = -r0
            int r0 = -r0
            r9 = r1 ^ r0
            r0 = r0 & r1
            int r0 = r0 << r8
            int r9 = r9 + r0
            int r0 = r9 % 128
            f3003b = r0
            int r9 = r9 % r7
            r0 = 0
            goto L_0x011c
        L_0x0055:
            java.lang.String r1 = "04"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005f
            r0 = 0
            goto L_0x0060
        L_0x005f:
            r0 = 1
        L_0x0060:
            if (r0 == 0) goto L_0x0064
            goto L_0x011b
        L_0x0064:
            int r0 = f3003b
            r1 = r0 | 87
            int r1 = r1 << r8
            r0 = r0 ^ 87
            int r1 = r1 - r0
            int r0 = r1 % 128
            f3004c = r0
            int r1 = r1 % r7
            int r0 = f3004c
            r1 = r0 ^ 71
            r9 = r0 & 71
            r1 = r1 | r9
            int r1 = r1 << r8
            int r9 = ~r9
            r0 = r0 | 71
            r0 = r0 & r9
            int r0 = -r0
            r9 = r1 & r0
            r0 = r0 | r1
            int r9 = r9 + r0
            int r0 = r9 % 128
            f3003b = r0
            int r9 = r9 % r7
            r0 = 4
            goto L_0x011c
        L_0x008a:
            java.lang.String r1 = "03"
            boolean r0 = r0.equals(r1)
            r1 = 36
            if (r0 == 0) goto L_0x0097
            r0 = 36
            goto L_0x0099
        L_0x0097:
            r0 = 45
        L_0x0099:
            if (r0 == r1) goto L_0x009d
            goto L_0x011b
        L_0x009d:
            int r0 = f3003b
            r1 = r0 & 35
            r0 = r0 | 35
            r9 = r1 & r0
            r0 = r0 | r1
            int r9 = r9 + r0
            int r0 = r9 % 128
            f3004c = r0
            int r9 = r9 % r7
            int r0 = f3003b
            r1 = r0 & 79
            r0 = r0 | 79
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3004c = r0
            int r1 = r1 % r7
            r0 = 2
            goto L_0x011c
        L_0x00ba:
            java.lang.String r1 = "02"
            boolean r0 = r0.equals(r1)
            r1 = 21
            if (r0 == 0) goto L_0x00c7
            r0 = 21
            goto L_0x00c9
        L_0x00c7:
            r0 = 89
        L_0x00c9:
            if (r0 == r1) goto L_0x00cc
            goto L_0x011b
        L_0x00cc:
            int r0 = f3004c
            int r0 = r0 + 64
            int r0 = r0 - r8
            int r1 = r0 % 128
            f3003b = r1
            int r0 = r0 % r7
            int r0 = f3004c
            int r0 = r0 + 78
            int r0 = r0 - r8
            int r1 = r0 % 128
            f3003b = r1
            int r0 = r0 % r7
            r0 = 1
            goto L_0x011c
        L_0x00e2:
            java.lang.String r1 = "01"
            boolean r0 = r0.equals(r1)
            r1 = 48
            if (r0 == 0) goto L_0x00ef
            r0 = 48
            goto L_0x00f1
        L_0x00ef:
            r0 = 68
        L_0x00f1:
            if (r0 == r1) goto L_0x00f4
            goto L_0x011b
        L_0x00f4:
            int r0 = f3004c
            r1 = r0 & -118(0xffffffffffffff8a, float:NaN)
            int r9 = ~r0
            r9 = r9 & r2
            r1 = r1 | r9
            r0 = r0 & r2
            int r0 = r0 << r8
            r9 = r1 | r0
            int r9 = r9 << r8
            r0 = r0 ^ r1
            int r9 = r9 - r0
            int r0 = r9 % 128
            f3003b = r0
            int r9 = r9 % r7
            int r0 = f3003b
            r1 = r0 ^ 31
            r0 = r0 & 31
            int r0 = r0 << r8
            int r0 = -r0
            int r0 = -r0
            r9 = r1 & r0
            r0 = r0 | r1
            int r9 = r9 + r0
            int r0 = r9 % 128
            f3004c = r0
            int r9 = r9 % r7
            r0 = 3
            goto L_0x011c
        L_0x011b:
            r0 = -1
        L_0x011c:
            r1 = 0
            if (r0 == 0) goto L_0x0144
            if (r0 == r8) goto L_0x0129
            if (r0 == r7) goto L_0x0129
            if (r0 == r4) goto L_0x0129
            if (r0 == r3) goto L_0x0129
            r0 = r1
            goto L_0x0160
        L_0x0129:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r10 = r10.getApplicationContext()
            java.lang.Class<com.cardinalcommerce.a.setTextLocales> r3 = com.cardinalcommerce.p060a.setTextLocales.class
            r0.<init>(r10, r3)
            int r10 = f3003b
            int r10 = r10 + 101
            int r10 = r10 - r8
            r3 = r10 | -1
            int r3 = r3 << r8
            r10 = r10 ^ r5
            int r3 = r3 - r10
            int r10 = r3 % 128
            f3004c = r10
        L_0x0142:
            int r3 = r3 % r7
            goto L_0x0160
        L_0x0144:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r10 = r10.getApplicationContext()
            java.lang.Class<com.cardinalcommerce.a.setTextLocale> r3 = com.cardinalcommerce.p060a.setTextLocale.class
            r0.<init>(r10, r3)
            int r10 = f3004c
            r3 = r10 & 57
            r10 = r10 ^ 57
            r10 = r10 | r3
            int r10 = -r10
            int r10 = -r10
            int r10 = ~r10
            int r3 = r3 - r10
            int r3 = r3 - r8
            int r10 = r3 % 128
            f3003b = r10
            goto L_0x0142
        L_0x0160:
            if (r0 == 0) goto L_0x0164
            r10 = 1
            goto L_0x0165
        L_0x0164:
            r10 = 0
        L_0x0165:
            if (r10 == 0) goto L_0x01d0
            int r10 = f3003b
            r3 = r10 & 9
            int r4 = ~r3
            r10 = r10 | 9
            r10 = r10 & r4
            int r3 = r3 << r8
            int r3 = -r3
            int r3 = -r3
            r4 = r10 ^ r3
            r10 = r10 & r3
            int r10 = r10 << r8
            int r4 = r4 + r10
            int r10 = r4 % 128
            f3004c = r10
            int r4 = r4 % r7
            if (r4 != 0) goto L_0x017f
            goto L_0x0180
        L_0x017f:
            r6 = 1
        L_0x0180:
            r10 = 67108864(0x4000000, float:1.5046328E-36)
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            java.lang.String r4 = "UiCustomization"
            java.lang.String r5 = "StepUpData"
            if (r6 == r8) goto L_0x01a6
            r0.putExtra(r5, r11)
            r0.putExtra(r4, r12)
            android.content.Intent r11 = r0.addFlags(r3)
            r11.addFlags(r10)
            java.lang.ref.WeakReference<android.content.Context> r10 = f3002a
            java.lang.Object r10 = r10.get()
            android.content.Context r10 = (android.content.Context) r10
            r10.startActivity(r0)
            int r10 = r1.length     // Catch:{ all -> 0x01a4 }
            goto L_0x01be
        L_0x01a4:
            r10 = move-exception
            throw r10
        L_0x01a6:
            r0.putExtra(r5, r11)
            r0.putExtra(r4, r12)
            android.content.Intent r11 = r0.addFlags(r3)
            r11.addFlags(r10)
            java.lang.ref.WeakReference<android.content.Context> r10 = f3002a
            java.lang.Object r10 = r10.get()
            android.content.Context r10 = (android.content.Context) r10
            r10.startActivity(r0)
        L_0x01be:
            int r10 = f3004c
            r11 = r10 & 117(0x75, float:1.64E-43)
            r10 = r10 ^ r2
            r10 = r10 | r11
            int r10 = -r10
            int r10 = -r10
            r12 = r11 | r10
            int r12 = r12 << r8
            r10 = r10 ^ r11
            int r12 = r12 - r10
            int r10 = r12 % 128
            f3003b = r10
            int r12 = r12 % r7
        L_0x01d0:
            int r10 = f3004c
            int r10 = r10 + 101
            int r10 = r10 - r8
            int r10 = r10 - r8
            int r11 = r10 % 128
            f3003b = r11
            int r10 = r10 % r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextAppearance.cca_continue(android.content.Context, com.cardinalcommerce.a.setBaselineAligned, com.cardinalcommerce.shared.userinterfaces.UiCustomization):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r1 != null) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (f3002a != null) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getInstance() {
        /*
            int r0 = f3004c
            r1 = r0 ^ 45
            r2 = 45
            r0 = r0 & r2
            r3 = 1
            int r0 = r0 << r3
            int r0 = -r0
            int r0 = -r0
            r4 = r1 & r0
            r0 = r0 | r1
            int r4 = r4 + r0
            int r0 = r4 % 128
            f3003b = r0
            r0 = 2
            int r4 = r4 % r0
            if (r4 == 0) goto L_0x0019
            r1 = 1
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            r4 = 0
            if (r1 == r3) goto L_0x0022
            java.lang.ref.WeakReference<android.content.Context> r1 = f3002a
            if (r1 == 0) goto L_0x0051
            goto L_0x0029
        L_0x0022:
            java.lang.ref.WeakReference<android.content.Context> r1 = f3002a
            super.hashCode()     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x0051
        L_0x0029:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r5 = "finish_activity"
            r1.<init>(r5)
            getInstance = r3
            java.lang.ref.WeakReference<android.content.Context> r5 = f3002a
            java.lang.Object r5 = r5.get()
            android.content.Context r5 = (android.content.Context) r5
            r5.sendBroadcast(r1)
            int r1 = f3003b
            r5 = r1 | 19
            int r5 = r5 << r3
            r6 = r1 & -20
            int r1 = ~r1
            r1 = r1 & 19
            r1 = r1 | r6
            int r1 = -r1
            int r1 = ~r1
            int r5 = r5 - r1
            int r5 = r5 - r3
            int r1 = r5 % 128
            f3004c = r1
            int r5 = r5 % r0
        L_0x0051:
            int r1 = f3004c
            r5 = r1 ^ 45
            r6 = r1 & 45
            r5 = r5 | r6
            int r3 = r5 << 1
            r5 = r1 & -46
            int r1 = ~r1
            r1 = r1 & r2
            r1 = r1 | r5
            int r1 = -r1
            r2 = r3 & r1
            r1 = r1 | r3
            int r2 = r2 + r1
            int r1 = r2 % 128
            f3003b = r1
            int r2 = r2 % r0
            r1 = 79
            if (r2 == 0) goto L_0x006f
            r0 = 79
        L_0x006f:
            if (r0 == r1) goto L_0x0072
            return
        L_0x0072:
            super.hashCode()     // Catch:{ all -> 0x0076 }
            return
        L_0x0076:
            r0 = move-exception
            throw r0
        L_0x0078:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextAppearance.getInstance():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if ((!r8.setChallengeTimeout.equalsIgnoreCase(com.didichuxing.sofa.animation.C16471q.f49113b) ? (char) 19 : 29) != 19) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        if ((!r1 ? '@' : ',') != ',') goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getInstance(com.cardinalcommerce.p060a.setBaselineAligned r8, android.content.Context r9, com.cardinalcommerce.shared.userinterfaces.UiCustomization r10) {
        /*
            int r0 = f3004c
            r1 = r0 & 81
            r0 = r0 | 81
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3003b = r0
            int r1 = r1 % 2
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r0 = com.cardinalcommerce.p060a.setProgressTintBlendMode.init
            boolean r1 = getInstance
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0017
            r1 = 0
            goto L_0x0018
        L_0x0017:
            r1 = 1
        L_0x0018:
            if (r1 == r3) goto L_0x017d
            int r1 = f3003b
            r4 = r1 & 99
            r1 = r1 ^ 99
            r1 = r1 | r4
            int r1 = ~r1
            int r4 = r4 - r1
            int r4 = r4 - r3
            int r1 = r4 % 128
            f3004c = r1
            int r4 = r4 % 2
            if (r4 != 0) goto L_0x002e
            r1 = 0
            goto L_0x002f
        L_0x002e:
            r1 = 1
        L_0x002f:
            java.lang.String r4 = "Y"
            r5 = 0
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = r8.setChallengeTimeout
            boolean r1 = r1.equalsIgnoreCase(r4)
            r4 = 19
            if (r1 != 0) goto L_0x0041
            r1 = 19
            goto L_0x0043
        L_0x0041:
            r1 = 29
        L_0x0043:
            if (r1 == r4) goto L_0x005b
            goto L_0x011d
        L_0x0047:
            java.lang.String r1 = r8.setChallengeTimeout
            boolean r1 = r1.equalsIgnoreCase(r4)
            super.hashCode()     // Catch:{ all -> 0x017b }
            r4 = 44
            if (r1 != 0) goto L_0x0057
            r1 = 64
            goto L_0x0059
        L_0x0057:
            r1 = 44
        L_0x0059:
            if (r1 == r4) goto L_0x011d
        L_0x005b:
            int r1 = f3003b
            r4 = r1 & 51
            r6 = 51
            r1 = r1 ^ r6
            r1 = r1 | r4
            r7 = r4 | r1
            int r7 = r7 << r3
            r1 = r1 ^ r4
            int r7 = r7 - r1
            int r1 = r7 % 128
            f3004c = r1
            int r7 = r7 % 2
            java.lang.String r1 = r8.setChallengeTimeout
            java.lang.String r4 = "N"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x007a
            goto L_0x011d
        L_0x007a:
            java.lang.String r1 = r8.getWarnings
            boolean r1 = r1.equalsIgnoreCase(r4)
            r4 = 98
            if (r1 == 0) goto L_0x0087
            r1 = 52
            goto L_0x0089
        L_0x0087:
            r1 = 98
        L_0x0089:
            if (r1 == r4) goto L_0x00c9
            int r0 = f3004c
            r1 = r0 ^ 63
            r0 = r0 & 63
            r0 = r0 | r1
            int r0 = r0 << r3
            int r1 = -r1
            r2 = r0 & r1
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f3003b = r0
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x00a3
            r0 = 51
            goto L_0x00a5
        L_0x00a3:
            r0 = 65
        L_0x00a5:
            cca_continue(r9, r8, r10)
            if (r0 == r6) goto L_0x00ab
            goto L_0x00ae
        L_0x00ab:
            super.hashCode()     // Catch:{ all -> 0x00c7 }
        L_0x00ae:
            int r8 = f3004c
            r9 = r8 ^ 85
            r10 = r8 & 85
            r9 = r9 | r10
            int r9 = r9 << r3
            r10 = r8 & -86
            int r8 = ~r8
            r8 = r8 & 85
            r8 = r8 | r10
            int r8 = -r8
            int r8 = ~r8
            int r9 = r9 - r8
            int r9 = r9 - r3
            int r8 = r9 % 128
            f3003b = r8
            int r9 = r9 % 2
            return
        L_0x00c7:
            r8 = move-exception
            throw r8
        L_0x00c9:
            com.cardinalcommerce.emvco.events.RuntimeErrorEvent r9 = new com.cardinalcommerce.emvco.events.RuntimeErrorEvent
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r8 = r8.setChallengeTimeout
            r10.append(r8)
            java.lang.String r8 = " : "
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            java.lang.String r10 = "101"
            r9.<init>(r10, r8)
            r0.runtimeError(r9)
            com.cardinalcommerce.p060a.setProgressTintBlendMode.cca_continue()
            android.os.CountDownTimer r8 = com.cardinalcommerce.p060a.setProgressTintBlendMode.configure
            if (r8 == 0) goto L_0x00ef
            r8 = 1
            goto L_0x00f0
        L_0x00ef:
            r8 = 0
        L_0x00f0:
            if (r8 == r3) goto L_0x00f4
            goto L_0x017d
        L_0x00f4:
            int r8 = f3004c
            r9 = r8 & 31
            r8 = r8 | 31
            int r9 = r9 + r8
            int r8 = r9 % 128
            f3003b = r8
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x0105
            r8 = 0
            goto L_0x0106
        L_0x0105:
            r8 = 1
        L_0x0106:
            if (r8 == 0) goto L_0x0110
            android.os.CountDownTimer r8 = com.cardinalcommerce.p060a.setProgressTintBlendMode.configure
            r8.cancel()
            com.cardinalcommerce.p060a.setProgressTintBlendMode.configure = r5
            goto L_0x017d
        L_0x0110:
            android.os.CountDownTimer r8 = com.cardinalcommerce.p060a.setProgressTintBlendMode.configure
            r8.cancel()
            com.cardinalcommerce.p060a.setProgressTintBlendMode.configure = r5
            super.hashCode()     // Catch:{ all -> 0x011b }
            goto L_0x017d
        L_0x011b:
            r8 = move-exception
            throw r8
        L_0x011d:
            com.cardinalcommerce.emvco.events.CompletionEvent r9 = new com.cardinalcommerce.emvco.events.CompletionEvent
            java.lang.String r10 = r8.setRequestTimeout
            java.lang.String r8 = r8.setChallengeTimeout
            r9.<init>(r10, r8)
            getInstance()
            com.cardinalcommerce.p060a.setProgressTintBlendMode.cca_continue()
            android.os.CountDownTimer r8 = com.cardinalcommerce.p060a.setProgressTintBlendMode.configure
            if (r8 == 0) goto L_0x0131
            r2 = 1
        L_0x0131:
            if (r2 == 0) goto L_0x0166
            int r8 = f3003b
            r10 = r8 & 91
            r8 = r8 ^ 91
            r8 = r8 | r10
            int r8 = -r8
            int r8 = -r8
            r1 = r10 ^ r8
            r8 = r8 & r10
            int r8 = r8 << r3
            int r1 = r1 + r8
            int r8 = r1 % 128
            f3004c = r8
            int r1 = r1 % 2
            android.os.CountDownTimer r8 = com.cardinalcommerce.p060a.setProgressTintBlendMode.configure
            r8.cancel()
            com.cardinalcommerce.p060a.setProgressTintBlendMode.configure = r5
            int r8 = f3003b
            r10 = r8 ^ 45
            r1 = r8 & 45
            r10 = r10 | r1
            int r10 = r10 << r3
            int r1 = ~r1
            r8 = r8 | 45
            r8 = r8 & r1
            int r8 = -r8
            r1 = r10 | r8
            int r1 = r1 << r3
            r8 = r8 ^ r10
            int r1 = r1 - r8
            int r8 = r1 % 128
            f3004c = r8
            int r1 = r1 % 2
        L_0x0166:
            r0.completed(r9)
            int r8 = f3004c
            r9 = r8 | 17
            int r10 = r9 << 1
            r8 = r8 & 17
            int r8 = ~r8
            r8 = r8 & r9
            int r10 = r10 - r8
            int r8 = r10 % 128
            f3003b = r8
            int r10 = r10 % 2
            return
        L_0x017b:
            r8 = move-exception
            throw r8
        L_0x017d:
            int r8 = f3004c
            int r8 = r8 + 79
            int r8 = r8 - r3
            int r8 = r8 - r2
            int r8 = r8 - r3
            int r9 = r8 % 128
            f3003b = r9
            int r8 = r8 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextAppearance.getInstance(com.cardinalcommerce.a.setBaselineAligned, android.content.Context, com.cardinalcommerce.shared.userinterfaces.UiCustomization):void");
    }
}
