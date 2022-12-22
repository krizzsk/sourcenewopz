package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzoa extends zzob {
    private static final int[] zzbhu = new int[0];
    private final zzof zzbhv;
    private final AtomicReference<zznz> zzbhw;

    public zzoa() {
        this((zzof) null);
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    private static int zzg(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private zzoa(zzof zzof) {
        this.zzbhv = null;
        this.zzbhw = new AtomicReference<>(new zznz());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x017f, code lost:
        if (r9.zzahk <= r15) goto L_0x0184;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzog[] zza(com.google.android.gms.internal.ads.zzib[] r34, com.google.android.gms.internal.ads.zznu[] r35, int[][][] r36) throws com.google.android.gms.internal.ads.zzhe {
        /*
            r33 = this;
            r0 = r34
            int r1 = r0.length
            com.google.android.gms.internal.ads.zzog[] r2 = new com.google.android.gms.internal.ads.zzog[r1]
            r3 = r33
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zznz> r4 = r3.zzbhw
            java.lang.Object r4 = r4.get()
            com.google.android.gms.internal.ads.zznz r4 = (com.google.android.gms.internal.ads.zznz) r4
            r6 = 0
            r7 = 0
        L_0x0011:
            r8 = 2
            if (r6 >= r1) goto L_0x0257
            r12 = r0[r6]
            int r12 = r12.getTrackType()
            if (r8 != r12) goto L_0x0241
            if (r7 != 0) goto L_0x0234
            r7 = r35[r6]
            r12 = r36[r6]
            int r13 = r4.zzbho
            int r14 = r4.zzbhp
            int r15 = r4.zzbhq
            int r9 = r4.viewportWidth
            int r8 = r4.viewportHeight
            boolean r5 = r4.zzbht
            boolean r10 = r4.zzbhr
            boolean r11 = r4.zzbhs
            r22 = r1
            r18 = r4
            r0 = 0
            r3 = 0
            r4 = 0
            r19 = 0
            r20 = -1
            r21 = -1
        L_0x003f:
            int r1 = r7.length
            if (r3 >= r1) goto L_0x0214
            com.google.android.gms.internal.ads.zznr r1 = r7.zzbf(r3)
            r23 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r24 = r2
            int r2 = r1.length
            r7.<init>(r2)
            r25 = r6
            r2 = 0
        L_0x0055:
            int r6 = r1.length
            if (r2 >= r6) goto L_0x0063
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            r7.add(r6)
            int r2 = r2 + 1
            goto L_0x0055
        L_0x0063:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r9 == r2) goto L_0x0133
            if (r8 != r2) goto L_0x006c
            goto L_0x0133
        L_0x006c:
            r26 = r4
            r6 = 0
        L_0x006f:
            int r4 = r1.length
            if (r6 >= r4) goto L_0x00fd
            com.google.android.gms.internal.ads.zzht r4 = r1.zzbe(r6)
            r27 = r0
            int r0 = r4.width
            if (r0 <= 0) goto L_0x00e3
            int r0 = r4.height
            if (r0 <= 0) goto L_0x00e3
            int r0 = r4.width
            r28 = r10
            int r10 = r4.height
            r29 = r5
            if (r5 == 0) goto L_0x009f
            if (r0 <= r10) goto L_0x008f
            r5 = 1
            goto L_0x0090
        L_0x008f:
            r5 = 0
        L_0x0090:
            r30 = r8
            if (r9 <= r8) goto L_0x0096
            r8 = 1
            goto L_0x0097
        L_0x0096:
            r8 = 0
        L_0x0097:
            if (r5 == r8) goto L_0x00a1
            r5 = r9
            r31 = r5
            r8 = r30
            goto L_0x00a6
        L_0x009f:
            r30 = r8
        L_0x00a1:
            r8 = r9
            r31 = r8
            r5 = r30
        L_0x00a6:
            int r9 = r0 * r5
            r32 = r15
            int r15 = r10 * r8
            if (r9 < r15) goto L_0x00b8
            android.graphics.Point r5 = new android.graphics.Point
            int r0 = com.google.android.gms.internal.ads.zzpt.zzh(r15, r0)
            r5.<init>(r8, r0)
            goto L_0x00c2
        L_0x00b8:
            android.graphics.Point r0 = new android.graphics.Point
            int r8 = com.google.android.gms.internal.ads.zzpt.zzh(r9, r10)
            r0.<init>(r8, r5)
            r5 = r0
        L_0x00c2:
            int r0 = r4.width
            int r8 = r4.height
            int r0 = r0 * r8
            int r8 = r4.width
            int r9 = r5.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r8 < r9) goto L_0x00ed
            int r4 = r4.height
            int r5 = r5.y
            float r5 = (float) r5
            float r5 = r5 * r10
            int r5 = (int) r5
            if (r4 < r5) goto L_0x00ed
            if (r0 >= r2) goto L_0x00ed
            r2 = r0
            goto L_0x00ed
        L_0x00e3:
            r29 = r5
            r30 = r8
            r31 = r9
            r28 = r10
            r32 = r15
        L_0x00ed:
            int r6 = r6 + 1
            r0 = r27
            r10 = r28
            r5 = r29
            r8 = r30
            r9 = r31
            r15 = r32
            goto L_0x006f
        L_0x00fd:
            r27 = r0
            r29 = r5
            r30 = r8
            r31 = r9
            r28 = r10
            r32 = r15
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r0) goto L_0x0141
            int r0 = r7.size()
            r4 = 1
            int r0 = r0 - r4
        L_0x0114:
            if (r0 < 0) goto L_0x0141
            java.lang.Object r4 = r7.get(r0)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzht r4 = r1.zzbe(r4)
            int r4 = r4.zzfd()
            r5 = -1
            if (r4 == r5) goto L_0x012d
            if (r4 <= r2) goto L_0x0130
        L_0x012d:
            r7.remove(r0)
        L_0x0130:
            int r0 = r0 + -1
            goto L_0x0114
        L_0x0133:
            r27 = r0
            r26 = r4
            r29 = r5
            r30 = r8
            r31 = r9
            r28 = r10
            r32 = r15
        L_0x0141:
            r0 = r12[r3]
            r5 = r19
            r6 = r20
            r8 = r21
            r4 = r26
            r2 = 0
        L_0x014c:
            int r9 = r1.length
            if (r2 >= r9) goto L_0x01f6
            r9 = r0[r2]
            boolean r9 = zze(r9, r11)
            if (r9 == 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzht r9 = r1.zzbe(r2)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            boolean r10 = r7.contains(r10)
            if (r10 == 0) goto L_0x0186
            int r10 = r9.width
            r15 = -1
            if (r10 == r15) goto L_0x016f
            int r10 = r9.width
            if (r10 > r13) goto L_0x0186
        L_0x016f:
            int r10 = r9.height
            if (r10 == r15) goto L_0x0177
            int r10 = r9.height
            if (r10 > r14) goto L_0x0186
        L_0x0177:
            int r10 = r9.zzahk
            if (r10 == r15) goto L_0x0182
            int r10 = r9.zzahk
            r15 = r32
            if (r10 > r15) goto L_0x0188
            goto L_0x0184
        L_0x0182:
            r15 = r32
        L_0x0184:
            r10 = 1
            goto L_0x0189
        L_0x0186:
            r15 = r32
        L_0x0188:
            r10 = 0
        L_0x0189:
            if (r10 != 0) goto L_0x0195
            if (r28 == 0) goto L_0x018e
            goto L_0x0195
        L_0x018e:
            r21 = r0
            r19 = r1
            r20 = r4
            goto L_0x01ea
        L_0x0195:
            r19 = r1
            r20 = r4
            if (r10 == 0) goto L_0x019d
            r1 = 2
            goto L_0x019e
        L_0x019d:
            r1 = 1
        L_0x019e:
            r4 = r0[r2]
            r21 = r0
            r0 = 0
            boolean r4 = zze(r4, r0)
            if (r4 == 0) goto L_0x01ab
            int r1 = r1 + 1000
        L_0x01ab:
            if (r1 <= r5) goto L_0x01af
            r0 = 1
            goto L_0x01b0
        L_0x01af:
            r0 = 0
        L_0x01b0:
            if (r1 != r5) goto L_0x01d3
            int r0 = r9.zzfd()
            if (r0 == r6) goto L_0x01c1
            int r0 = r9.zzfd()
            int r0 = zzg(r0, r6)
            goto L_0x01c7
        L_0x01c1:
            int r0 = r9.zzahk
            int r0 = zzg(r0, r8)
        L_0x01c7:
            if (r4 == 0) goto L_0x01ce
            if (r10 == 0) goto L_0x01ce
            if (r0 <= 0) goto L_0x01d2
            goto L_0x01d0
        L_0x01ce:
            if (r0 >= 0) goto L_0x01d2
        L_0x01d0:
            r0 = 1
            goto L_0x01d3
        L_0x01d2:
            r0 = 0
        L_0x01d3:
            if (r0 == 0) goto L_0x01ea
            int r0 = r9.zzahk
            int r4 = r9.zzfd()
            r8 = r0
            r5 = r1
            r6 = r4
            r27 = r19
            r4 = r2
            goto L_0x01ec
        L_0x01e2:
            r21 = r0
            r19 = r1
            r20 = r4
            r15 = r32
        L_0x01ea:
            r4 = r20
        L_0x01ec:
            int r2 = r2 + 1
            r32 = r15
            r1 = r19
            r0 = r21
            goto L_0x014c
        L_0x01f6:
            r20 = r4
            r15 = r32
            int r3 = r3 + 1
            r19 = r5
            r21 = r8
            r7 = r23
            r2 = r24
            r0 = r27
            r10 = r28
            r5 = r29
            r8 = r30
            r9 = r31
            r20 = r6
            r6 = r25
            goto L_0x003f
        L_0x0214:
            r27 = r0
            r24 = r2
            r26 = r4
            r25 = r6
            if (r27 != 0) goto L_0x0220
            r9 = 0
            goto L_0x0229
        L_0x0220:
            com.google.android.gms.internal.ads.zzoc r9 = new com.google.android.gms.internal.ads.zzoc
            r1 = r26
            r0 = r27
            r9.<init>(r0, r1)
        L_0x0229:
            r24[r25] = r9
            r0 = r24[r25]
            if (r0 == 0) goto L_0x0231
            r11 = 1
            goto L_0x0232
        L_0x0231:
            r11 = 0
        L_0x0232:
            r7 = r11
            goto L_0x023c
        L_0x0234:
            r22 = r1
            r24 = r2
            r18 = r4
            r25 = r6
        L_0x023c:
            r0 = r35[r25]
            int r0 = r0.length
            goto L_0x0249
        L_0x0241:
            r22 = r1
            r24 = r2
            r18 = r4
            r25 = r6
        L_0x0249:
            int r6 = r25 + 1
            r3 = r33
            r0 = r34
            r4 = r18
            r1 = r22
            r2 = r24
            goto L_0x0011
        L_0x0257:
            r24 = r2
            r18 = r4
            r3 = r1
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x025f:
            if (r0 >= r3) goto L_0x03ec
            r4 = r34[r0]
            int r4 = r4.getTrackType()
            r5 = 1
            if (r4 == r5) goto L_0x0371
            r5 = 2
            if (r4 == r5) goto L_0x036a
            r5 = 3
            if (r4 == r5) goto L_0x02e6
            r4 = r34[r0]
            r4.getTrackType()
            r4 = r35[r0]
            r5 = r36[r0]
            r6 = r18
            boolean r7 = r6.zzbhs
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0281:
            int r12 = r4.length
            if (r8 >= r12) goto L_0x02d3
            com.google.android.gms.internal.ads.zznr r12 = r4.zzbf(r8)
            r13 = r5[r8]
            r14 = 0
        L_0x028c:
            int r15 = r12.length
            if (r14 >= r15) goto L_0x02cc
            r15 = r13[r14]
            boolean r15 = zze(r15, r7)
            if (r15 == 0) goto L_0x02c1
            com.google.android.gms.internal.ads.zzht r15 = r12.zzbe(r14)
            int r15 = r15.zzaie
            r17 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x02a6
            r15 = 1
            goto L_0x02a7
        L_0x02a6:
            r15 = 0
        L_0x02a7:
            r22 = r3
            if (r15 == 0) goto L_0x02ad
            r15 = 2
            goto L_0x02ae
        L_0x02ad:
            r15 = 1
        L_0x02ae:
            r3 = r13[r14]
            r18 = r4
            r4 = 0
            boolean r3 = zze(r3, r4)
            if (r3 == 0) goto L_0x02bb
            int r15 = r15 + 1000
        L_0x02bb:
            if (r15 <= r10) goto L_0x02c5
            r11 = r12
            r9 = r14
            r10 = r15
            goto L_0x02c5
        L_0x02c1:
            r22 = r3
            r18 = r4
        L_0x02c5:
            int r14 = r14 + 1
            r4 = r18
            r3 = r22
            goto L_0x028c
        L_0x02cc:
            r22 = r3
            r18 = r4
            int r8 = r8 + 1
            goto L_0x0281
        L_0x02d3:
            r22 = r3
            if (r11 != 0) goto L_0x02d9
            r3 = 0
            goto L_0x02de
        L_0x02d9:
            com.google.android.gms.internal.ads.zzoc r3 = new com.google.android.gms.internal.ads.zzoc
            r3.<init>(r11, r9)
        L_0x02de:
            r24[r0] = r3
            r5 = -1
            r15 = 0
            r16 = 2
            goto L_0x03e4
        L_0x02e6:
            r22 = r3
            r6 = r18
            if (r2 != 0) goto L_0x036e
            r2 = r35[r0]
            r3 = r36[r0]
            boolean r4 = r6.zzbhs
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x02f6:
            int r11 = r2.length
            if (r7 >= r11) goto L_0x0351
            com.google.android.gms.internal.ads.zznr r11 = r2.zzbf(r7)
            r12 = r3[r7]
            r13 = r10
            r10 = r9
            r9 = r8
            r8 = 0
        L_0x0304:
            int r14 = r11.length
            if (r8 >= r14) goto L_0x0348
            r14 = r12[r8]
            boolean r14 = zze(r14, r4)
            if (r14 == 0) goto L_0x0342
            com.google.android.gms.internal.ads.zzht r14 = r11.zzbe(r8)
            int r15 = r14.zzaie
            r17 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x031e
            r15 = 1
            goto L_0x031f
        L_0x031e:
            r15 = 0
        L_0x031f:
            int r14 = r14.zzaie
            r16 = 2
            r14 = r14 & 2
            if (r14 == 0) goto L_0x0329
            r14 = 1
            goto L_0x032a
        L_0x0329:
            r14 = 0
        L_0x032a:
            if (r15 == 0) goto L_0x032e
            r14 = 3
            goto L_0x0331
        L_0x032e:
            if (r14 == 0) goto L_0x0344
            r14 = 1
        L_0x0331:
            r15 = r12[r8]
            r5 = 0
            boolean r15 = zze(r15, r5)
            if (r15 == 0) goto L_0x033c
            int r14 = r14 + 1000
        L_0x033c:
            if (r14 <= r10) goto L_0x0344
            r9 = r8
            r13 = r11
            r10 = r14
            goto L_0x0344
        L_0x0342:
            r16 = 2
        L_0x0344:
            int r8 = r8 + 1
            r5 = 3
            goto L_0x0304
        L_0x0348:
            r16 = 2
            int r7 = r7 + 1
            r8 = r9
            r9 = r10
            r10 = r13
            r5 = 3
            goto L_0x02f6
        L_0x0351:
            r16 = 2
            if (r10 != 0) goto L_0x0357
            r2 = 0
            goto L_0x035c
        L_0x0357:
            com.google.android.gms.internal.ads.zzoc r2 = new com.google.android.gms.internal.ads.zzoc
            r2.<init>(r10, r8)
        L_0x035c:
            r24[r0] = r2
            r2 = r24[r0]
            if (r2 == 0) goto L_0x0364
            r4 = 1
            goto L_0x0365
        L_0x0364:
            r4 = 0
        L_0x0365:
            r2 = r4
        L_0x0366:
            r5 = -1
            r15 = 0
            goto L_0x03e4
        L_0x036a:
            r22 = r3
            r6 = r18
        L_0x036e:
            r16 = 2
            goto L_0x0366
        L_0x0371:
            r22 = r3
            r6 = r18
            r16 = 2
            if (r1 != 0) goto L_0x0366
            r1 = r35[r0]
            r3 = r36[r0]
            boolean r4 = r6.zzbhs
            r5 = 0
            r7 = 0
            r8 = -1
            r9 = -1
        L_0x0383:
            int r10 = r1.length
            if (r5 >= r10) goto L_0x03cb
            com.google.android.gms.internal.ads.zznr r10 = r1.zzbf(r5)
            r11 = r3[r5]
            r12 = r9
            r9 = r8
            r8 = r7
            r7 = 0
        L_0x0391:
            int r13 = r10.length
            if (r7 >= r13) goto L_0x03c4
            r13 = r11[r7]
            boolean r13 = zze(r13, r4)
            if (r13 == 0) goto L_0x03c0
            com.google.android.gms.internal.ads.zzht r13 = r10.zzbe(r7)
            r14 = r11[r7]
            int r13 = r13.zzaie
            r15 = 1
            r13 = r13 & r15
            if (r13 == 0) goto L_0x03ab
            r13 = 1
            goto L_0x03ac
        L_0x03ab:
            r13 = 0
        L_0x03ac:
            if (r13 == 0) goto L_0x03b0
            r13 = 2
            goto L_0x03b1
        L_0x03b0:
            r13 = 1
        L_0x03b1:
            r15 = 0
            boolean r14 = zze(r14, r15)
            if (r14 == 0) goto L_0x03ba
            int r13 = r13 + 1000
        L_0x03ba:
            if (r13 <= r8) goto L_0x03c1
            r9 = r5
            r12 = r7
            r8 = r13
            goto L_0x03c1
        L_0x03c0:
            r15 = 0
        L_0x03c1:
            int r7 = r7 + 1
            goto L_0x0391
        L_0x03c4:
            r15 = 0
            int r5 = r5 + 1
            r7 = r8
            r8 = r9
            r9 = r12
            goto L_0x0383
        L_0x03cb:
            r5 = -1
            r15 = 0
            if (r8 != r5) goto L_0x03d1
            r3 = 0
            goto L_0x03da
        L_0x03d1:
            com.google.android.gms.internal.ads.zznr r1 = r1.zzbf(r8)
            com.google.android.gms.internal.ads.zzoc r3 = new com.google.android.gms.internal.ads.zzoc
            r3.<init>(r1, r9)
        L_0x03da:
            r24[r0] = r3
            r1 = r24[r0]
            if (r1 == 0) goto L_0x03e2
            r4 = 1
            goto L_0x03e3
        L_0x03e2:
            r4 = 0
        L_0x03e3:
            r1 = r4
        L_0x03e4:
            int r0 = r0 + 1
            r18 = r6
            r3 = r22
            goto L_0x025f
        L_0x03ec:
            return r24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoa.zza(com.google.android.gms.internal.ads.zzib[], com.google.android.gms.internal.ads.zznu[], int[][][]):com.google.android.gms.internal.ads.zzog[]");
    }
}
