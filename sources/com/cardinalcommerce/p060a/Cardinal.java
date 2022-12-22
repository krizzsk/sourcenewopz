package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.Cardinal */
public final class Cardinal extends setTextAppearance {

    /* renamed from: a */
    private static final CardinalRenderType f2336a = CardinalRenderType.cca_continue();

    /* renamed from: b */
    private static int f2337b = 0;

    /* renamed from: c */
    private static int f2338c = 1;

    Cardinal() {
    }

    static {
        int i = f2337b;
        int i2 = ((i ^ 107) | (i & 107)) << 1;
        int i3 = -(((~i) & 107) | (i & -108));
        int i4 = (i2 & i3) + (i3 | i2);
        f2338c = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if ((!r6.setChallengeTimeout.equalsIgnoreCase(com.didichuxing.sofa.animation.C16471q.f49113b) ? '-' : 'a') != '-') goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if ((!r6.setChallengeTimeout.equalsIgnoreCase(com.didichuxing.sofa.animation.C16471q.f49113b) ? '!' : '0') != '0') goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        if (r6.setChallengeTimeout.equalsIgnoreCase("N") != false) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        if (r6.setChallengeTimeout.equalsIgnoreCase("N") != false) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d7, code lost:
        m1795a(r9, new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(10607), r7, r8, r10);
        r6 = f2337b;
        r8 = r6 & 73;
        r7 = ((((r6 ^ 73) | r8) << 1) - (~(-((r6 | 73) & (~r8))))) - 1;
        f2338c = r7 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f7, code lost:
        if ((r7 % 2) != 0) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f9, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fa, code lost:
        if (r4 == false) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ff, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0102, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void configure(com.cardinalcommerce.p060a.setBaselineAligned r6, android.app.Activity r7, com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r8, com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver r9, java.lang.String r10) {
        /*
            int r0 = f2337b
            r1 = r0 & 7
            r0 = r0 | 7
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2338c = r0
            int r1 = r1 % 2
            r0 = 39
            if (r1 != 0) goto L_0x0014
            r1 = 39
            goto L_0x0016
        L_0x0014:
            r1 = 42
        L_0x0016:
            r2 = 0
            java.lang.String r3 = "Y"
            r4 = 0
            r5 = 1
            if (r1 == r0) goto L_0x0030
            java.lang.String r0 = r6.setChallengeTimeout
            boolean r0 = r0.equalsIgnoreCase(r3)
            r1 = 45
            if (r0 != 0) goto L_0x002a
            r0 = 45
            goto L_0x002c
        L_0x002a:
            r0 = 97
        L_0x002c:
            if (r0 == r1) goto L_0x0044
            goto L_0x00d7
        L_0x0030:
            java.lang.String r0 = r6.setChallengeTimeout
            boolean r0 = r0.equalsIgnoreCase(r3)
            r1 = 95
            int r1 = r1 / r4
            r1 = 48
            if (r0 != 0) goto L_0x0040
            r0 = 33
            goto L_0x0042
        L_0x0040:
            r0 = 48
        L_0x0042:
            if (r0 == r1) goto L_0x00d7
        L_0x0044:
            int r0 = f2337b
            r1 = r0 & 19
            int r3 = ~r1
            r0 = r0 | 19
            r0 = r0 & r3
            int r1 = r1 << r5
            int r1 = -r1
            int r1 = -r1
            int r1 = ~r1
            int r0 = r0 - r1
            int r0 = r0 - r5
            int r1 = r0 % 128
            f2338c = r1
            int r0 = r0 % 2
            r1 = 85
            if (r0 != 0) goto L_0x005f
            r0 = 85
            goto L_0x0061
        L_0x005f:
            r0 = 51
        L_0x0061:
            java.lang.String r3 = "N"
            if (r0 == r1) goto L_0x006e
            java.lang.String r0 = r6.setChallengeTimeout
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x007a
            goto L_0x00d7
        L_0x006e:
            java.lang.String r0 = r6.setChallengeTimeout
            boolean r0 = r0.equalsIgnoreCase(r3)
            r1 = 44
            int r1 = r1 / r4
            if (r0 == 0) goto L_0x007a
            goto L_0x00d7
        L_0x007a:
            java.lang.String r0 = r6.getWarnings
            boolean r0 = r0.equalsIgnoreCase(r3)
            r1 = 62
            if (r0 == 0) goto L_0x0087
            r0 = 37
            goto L_0x0089
        L_0x0087:
            r0 = 62
        L_0x0089:
            if (r0 == r1) goto L_0x00ba
            int r9 = f2338c
            r10 = r9 | 86
            int r10 = r10 << r5
            r9 = r9 ^ 86
            int r10 = r10 - r9
            int r10 = r10 - r5
            int r9 = r10 % 128
            f2337b = r9
            int r10 = r10 % 2
            r9 = 30
            if (r10 == 0) goto L_0x00a1
            r10 = 32
            goto L_0x00a3
        L_0x00a1:
            r10 = 30
        L_0x00a3:
            if (r10 == r9) goto L_0x00b2
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r8 = r8.getUICustomization()
            cca_continue(r7, r6, r8)
            super.hashCode()     // Catch:{ all -> 0x00b0 }
            goto L_0x00b9
        L_0x00b0:
            r6 = move-exception
            throw r6
        L_0x00b2:
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r8 = r8.getUICustomization()
            cca_continue(r7, r6, r8)
        L_0x00b9:
            return
        L_0x00ba:
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r6 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r0 = 10608(0x2970, float:1.4865E-41)
            r6.<init>(r0)
            m1795a(r9, r6, r7, r8, r10)
            int r6 = f2337b
            int r6 = r6 + 46
            r7 = r6 ^ -1
            r6 = r6 & -1
            int r6 = r6 << r5
            int r7 = r7 + r6
            int r6 = r7 % 128
            f2338c = r6
            int r7 = r7 % 2
            return
        L_0x00d5:
            r6 = move-exception
            throw r6
        L_0x00d7:
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r6 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r0 = 10607(0x296f, float:1.4864E-41)
            r6.<init>(r0)
            m1795a(r9, r6, r7, r8, r10)
            int r6 = f2337b
            r7 = r6 ^ 73
            r8 = r6 & 73
            r7 = r7 | r8
            int r7 = r7 << r5
            int r8 = ~r8
            r6 = r6 | 73
            r6 = r6 & r8
            int r6 = -r6
            int r6 = ~r6
            int r7 = r7 - r6
            int r7 = r7 - r5
            int r6 = r7 % 128
            f2338c = r6
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x00fa
            r4 = 1
        L_0x00fa:
            if (r4 == 0) goto L_0x0102
            super.hashCode()     // Catch:{ all -> 0x0100 }
            return
        L_0x0100:
            r6 = move-exception
            throw r6
        L_0x0102:
            return
        L_0x0103:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.Cardinal.configure(com.cardinalcommerce.a.setBaselineAligned, android.app.Activity, com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters, com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
        if (r5 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (r5 != null) goto L_0x003d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m1795a(com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver r5, com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError r6, android.app.Activity r7, com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r8, java.lang.String r9) {
        /*
            int r0 = f2338c
            r1 = r0 | 41
            r2 = 1
            int r1 = r1 << r2
            r3 = r0 & -42
            int r0 = ~r0
            r0 = r0 & 41
            r0 = r0 | r3
            int r1 = r1 - r0
            int r0 = r1 % 128
            f2337b = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 == 0) goto L_0x0018
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            if (r1 == 0) goto L_0x002b
            com.cardinalcommerce.a.CardinalRenderType r0 = f2336a
            int r1 = r6.Cardinal
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = r6.init
            r0.configure(r1, r3, r9)
            if (r5 == 0) goto L_0x0065
            goto L_0x003d
        L_0x002b:
            com.cardinalcommerce.a.CardinalRenderType r1 = f2336a
            int r3 = r6.Cardinal
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = r6.init
            r1.configure(r3, r4, r9)
            r9 = 61
            int r9 = r9 / r0
            if (r5 == 0) goto L_0x0065
        L_0x003d:
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r9 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r0 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            r9.<init>(r0, r6)
            com.cardinalcommerce.a.CardinalRenderType r6 = f2336a
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment r8 = r8.getEnvironment()
            java.lang.String r8 = r8.toString()
            r6.configure(r8)
            android.content.Context r6 = r7.getApplicationContext()
            java.lang.String r7 = ""
            r5.onValidated(r6, r9, r7)
            int r5 = f2338c
            int r5 = r5 + 46
            int r5 = r5 - r2
            int r6 = r5 % 128
            f2337b = r6
            int r5 = r5 % 2
        L_0x0065:
            int r5 = f2338c
            r6 = r5 ^ 5
            r7 = r5 & 5
            r6 = r6 | r7
            int r6 = r6 << r2
            r7 = r5 & -6
            int r5 = ~r5
            r5 = r5 & 5
            r5 = r5 | r7
            int r5 = -r5
            int r5 = ~r5
            int r6 = r6 - r5
            int r6 = r6 - r2
            int r5 = r6 % 128
            f2337b = r5
            int r6 = r6 % 2
            r5 = 66
            if (r6 == 0) goto L_0x0084
            r6 = 23
            goto L_0x0086
        L_0x0084:
            r6 = 66
        L_0x0086:
            if (r6 == r5) goto L_0x008f
            r5 = 0
            super.hashCode()     // Catch:{ all -> 0x008d }
            return
        L_0x008d:
            r5 = move-exception
            throw r5
        L_0x008f:
            return
        L_0x0090:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.Cardinal.m1795a(com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver, com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError, android.app.Activity, com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters, java.lang.String):void");
    }
}
